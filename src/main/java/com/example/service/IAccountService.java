package com.example.service;

import java.util.List;

import com.example.entity.Account;
import com.example.entity.Customer;

public interface IAccountService
{

    Account save(Account account);

    List<Account> findByCustomer(Customer customer);

    Customer findById(Long id);

    List<Customer> findAll();

    List<Customer> findAll(int page, int pageSize);

    List<Customer> findByLastname(String lastname, int page, int pageSize);

}
