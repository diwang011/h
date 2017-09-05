package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
@Repository
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long>
{

    //List<Account> findByCustomer(Customer customer);
}
