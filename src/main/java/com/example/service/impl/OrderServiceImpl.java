package com.example.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Order;
import com.example.service.IOrderService;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService
{
    @Autowired  
    @PersistenceContext  
    private EntityManager entityManager;  
      
    private JPAQueryFactory queryFactory;

    @Override
    public List<Order> findAll()
    {
        return null;
   
    }

    @Override
    public Order findById(Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Order save(Order order)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Order> findByName(String name)
    {
        //添加查询条件  
        Predicate predicate = QOrder.order.orderName.eq(name);  
        JPAQuery<Order> jpaQuery = queryFactory.select(QOrder.order, QOrderItem.orderItem)  
                                        .from(QOrder.order, QOrderItem.orderItem)  
                                        .where(QOrderItem.orderItem.order.id.intValue().eq(QOrder.order.id.intValue()), predicate);  
        //拿到结果  
        return jpaQuery.fetch(); 
    }  

    
}
