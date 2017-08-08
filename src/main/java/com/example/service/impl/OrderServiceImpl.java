package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.entity.Order;
import com.example.entity.QOrder;
import com.example.entity.QOrderItem;
import com.example.repository.OrderRepository;
import com.example.service.IOrderService;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService
{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    @PersistenceContext
    private EntityManager em;

    private JPAQueryFactory queryFactory;

    @PostConstruct
    public void init()
    {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Order> findAll()
    {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Order findById(Long id)
    {
        return orderRepository.findOne(id);
    }

    @Override
    public Order save(Order order)
    {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> save(List<Order> orders)
    {
        return (List<Order>) orderRepository.save(orders);
    }

    @Override
    public List<Order> findByName(String orderStatus, int page, int pageSize)
    {
        QOrder qOrderQuery = QOrder.order;
        BooleanExpression exp = qOrderQuery.isNotNull();
        exp.and(qOrderQuery.orderStatus.eq(orderStatus));
        Pageable pageable = new PageRequest(page, pageSize);
        Page<Order> p = orderRepository.findAll(exp, pageable);
        return p.getContent();
    }

    @Override
    public List<Order> findByStatus(String status, int page, int pageSize)
    {
        // 添加查询条件
        QOrder qOrder = QOrder.order;
        QOrderItem qOrderItem = QOrderItem.orderItem;
        Predicate predicate = qOrder.orderStatus.eq(status).and(qOrderItem.id.between(1, 1000));
        JPAQuery<Order> jpaQuery = queryFactory.select(qOrder).from(qOrder,qOrderItem)
                .where(qOrderItem.order.id.longValue().eq(qOrder.id.longValue()),predicate);

        // 拿到结果
        jpaQuery.orderBy(qOrder.id.desc());
        jpaQuery.limit(page);
        jpaQuery.offset(pageSize);
        return jpaQuery.fetch();
    }

    @Override
    public List<Order> findByStatusAndAccount(String status, Account account, int page, int pageSize)
    {
        // 添加查询条件
        QOrder qOrder = QOrder.order;
        QOrderItem qOrderItem = QOrderItem.orderItem;
        Predicate predicate = qOrder.orderStatus.eq(status).and(qOrder.account.eq(account))
                .and(qOrderItem.id.between(1, 1000));
        // JPAQuery<Order> jpaQuery
        // =queryFactory.selectFrom(qOrder).leftJoin(qOrderItem).on(qOrderItem.order.id.longValue().eq(qOrder.id.longValue()));
        JPAQuery<Tuple> jpaQuery = queryFactory.select(qOrder, qOrderItem).from(qOrder, qOrderItem).rightJoin(qOrder)
                .on(qOrderItem.order.id.longValue().eq(qOrder.id.longValue()));

        jpaQuery.where(predicate);
        jpaQuery.orderBy(qOrder.id.desc());
        // 拿到结果
        jpaQuery.limit(pageSize);
        jpaQuery.offset(page);
        List<Order> list = new ArrayList<>();
        for (Tuple row : jpaQuery.fetch())
        {
            list.add(row.get(qOrder));
        }
        return list;
    }
}
