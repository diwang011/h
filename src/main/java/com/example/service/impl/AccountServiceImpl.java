package com.example.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.entity.Customer;
import com.example.repository.AccountRepository;
import com.example.service.IAccountService;

@Repository
@Transactional(readOnly = true)
class AccountServiceImpl implements IAccountService
{

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private AccountRepository repository;

    @Override
    public Customer findById(Long id)
    {
        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll()
    {
        return em.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    @Override
    public List<Customer> findAll(int page, int pageSize)
    {

        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);

        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    @Override
    public List<Customer> findByLastname(String lastname, int page, int pageSize)
    {

        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.lastname = ?1", Customer.class);

        query.setParameter(1, lastname);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Account save(Account account)
    {
        return repository.save(account);
    }

    @Override
    public List<Account> findByCustomer(Customer customer)
    {
        return null;
                //repository.findByCustomer(customer);
    }
}
