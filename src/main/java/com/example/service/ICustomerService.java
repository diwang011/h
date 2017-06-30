package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.Customer;

public interface ICustomerService
{

    Customer findById(Long id);

    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);
    
    Customer save(Customer customer);

    Page<Customer> findByLastname(String lastname, Pageable pageable);


}
