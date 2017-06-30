package com.example.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Customer;
import com.example.entity.User;
import com.example.service.IAccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountController
{
    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/add/{firstname}/{lastname}")
    public Account addUser(@PathVariable String firstname, @PathVariable String lastname)
    {
        Account account = new Account();
        account.setExpiryDate(new Date());
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        account.setCustomer(customer);
        return accountService.save(account);
    }

    @RequestMapping(value = "/")
    public List<Customer> getCustomers()
    {
        return accountService.findAll();
    }

    @RequestMapping(value = "getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable Long id)
    {
        return accountService.findById(id);
    }

}
