package com.example.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Order;

@Repository
@Transactional
public interface OrderRepository
        extends PagingAndSortingRepository<Order, Long>, QueryDslPredicateExecutor<Order>, QueryByExampleExecutor<Order>
{

}
