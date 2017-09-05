package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.ICustomerService;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements ICustomerService
{

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer findById(Long id)
    {
        return repository.findOne(id);
    }

    @Override
    public List<Customer> findAll()
    {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Customer save(Customer customer)
    {
        return repository.save(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByLastname(String lastname, Pageable pageable)
    {
        return repository.findByLastname(lastname, pageable);
    }
}