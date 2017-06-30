package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Order;
import com.example.service.IOrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController
{
    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/add/{firstname}/{lastname}")
    public Order addUser(@PathVariable String firstname, @PathVariable String lastname)
    {
        Order order = new Order();
        return orderService.save(order);
    }

    @RequestMapping(value = "/")
    public List<Order> getOrders()
    {
        return orderService.findAll();
    }

    @RequestMapping(value = "getOrderById/{id}")
    public Order getCustomerById(@PathVariable Long id)
    {
        return orderService.findById(id);
    }
    
    @RequestMapping(value = "getOrderByName/{id}")
    public List<Order> getOrderByName(@PathVariable String name)
    {
        return orderService.findByName(name);
    }

}
