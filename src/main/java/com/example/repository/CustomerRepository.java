package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Customer;

@Transactional(readOnly = true)
public interface CustomerRepository extends JpaRepository<Customer,Long>
{
    Page<Customer> findByLastname(String lastname, Pageable pageable); 

}
