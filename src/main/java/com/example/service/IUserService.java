package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface IUserService
{
    public List<User> findAll();

    public User saveUser(User book);

   
    public User findOne(long id);

    public void delete(long id);

    public List<User> findByName(String name);

}
