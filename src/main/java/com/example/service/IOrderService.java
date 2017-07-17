package com.example.service;

import java.util.List;

import com.example.entity.Account;
import com.example.entity.Order;

public interface IOrderService
{

    List<Order> findAll();

    Order findById(Long id);

    Order save(Order order);
    
    List<Order> save(List<Order> orders);
    
    List<Order> findByName(String name, int page, int pageSize);

    List<Order> findByStatus(String status, int page, int pageSize);

    List<Order> findByStatusAndAccount(String status, Account account, int page, int pageSize);
}
