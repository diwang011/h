package com.example.service;

import java.util.List;

import com.example.entity.Book;

public interface IBookService
{
    public List<Book> findAll();

    public Book findByName(String name);

    public List<Book> findByNameContaining(String name);
}
