package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customer;
import com.example.service.ICustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController
{
    @Autowired
    private ICustomerService customerService;


    @RequestMapping(value = "/")
    public List<Customer> getCustomer()
    {
        return customerService.findAll();
    }

}
