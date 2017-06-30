package com.example.service;

import java.util.List;

import com.example.entity.Author;

public interface IAuthorService
{
    public List<Author> findAll();

    public Author findByName(String name);

    public List<Author> findByNameContaining(String name);
}
