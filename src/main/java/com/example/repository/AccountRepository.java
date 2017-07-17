package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;

@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long>
{

    //List<Account> findByCustomer(Customer customer);
}
