package com.example.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Order;
import com.example.entity.OrderItem;
import com.example.service.IOrderService;
import com.example.web.model.BaseResponse;

@RestController
@RequestMapping(value = "/order")
public class OrderController
{
    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/add/{orderStatus}/{sku}")
    public Order addUser(@PathVariable String orderStatus, @PathVariable String sku)
    {
        Order order = bildOrder(orderStatus, sku);
        return orderService.save(order);
    }
    @RequestMapping(value = "/addAll/{orderStatus}/{sku}")
    public List<Order> addAllUser(@PathVariable String orderStatus, @PathVariable String sku)
    {
        List<Order> orders = new ArrayList<Order>();
        for (int i = 0; i < 10000; i++)
        {
            Order order = bildOrder(orderStatus + i, sku + i);
            orders.add(order);
        }

        return orderService.save(orders);
    }

    private Order bildOrder(String orderStatus, String sku)
    {
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setOrderStatus(orderStatus);
        Set<OrderItem> orderItems = new HashSet<OrderItem>();
        for (int i = 0; i < 10; i++)
        {
            OrderItem item = new OrderItem();
            item.setQuantity(i);
            item.setSku(sku + i);
            item.setOrder(order);
            orderItems.add(item);
        }
        order.setOrderItems(orderItems);
        Account account = new Account();
        account.setId(3L);
        order.setAccount(account);
        return order;
    }

    @RequestMapping(value = "/")
    public BaseResponse<List<Order>> getOrders()// @RequestParam Integer data
    {
        return bildResponse(orderService.findAll());
    }

    private BaseResponse<List<Order>> bildResponse(List<Order> orders)
    {
        BaseResponse<List<Order>> res = new BaseResponse<List<Order>>();
        res.setData(orders);
        res.setTotal(orders.size());
        return res;
    }

    @RequestMapping(value = "getOrderById/{id}")
    public Order getCustomerById(@PathVariable Long id)
    {
        return orderService.findById(id);
    }

    @RequestMapping(value = "getOrderByName/{name}/{page}/{pageSize}")
    public BaseResponse<List<Order>> getOrderByName(@PathVariable String name, @PathVariable int page,
            @PathVariable int pageSize)
    {
        return bildResponse(orderService.findByName(name, page, pageSize));
    }

    @RequestMapping(value = "getOrderByStatus/{name}/{page}/{pageSize}")
    public BaseResponse<List<Order>> getOrderByStatus(@PathVariable String name, @PathVariable int page,
            @PathVariable int pageSize)
    {
        return bildResponse(orderService.findByStatus(name, page, pageSize));
    }

    @RequestMapping(value = "getOrderByStatusAndAccount/{name}/{page}/{pageSize}")
    public BaseResponse<List<Order>> getOrderByStatusAndAccount(@PathVariable String name, @PathVariable int page,
            @PathVariable int pageSize)
    {
        Account account = new Account();
        account.setId(3L);
        return bildResponse(orderService.findByStatusAndAccount(name, account, page, pageSize));
    }

}
