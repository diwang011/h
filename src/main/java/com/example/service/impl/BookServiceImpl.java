package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.service.IBookService;

@Service
@Transactional
public class BookServiceImpl implements IBookService
{
    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }

    @Override
    public Book findByName(String name)
    {
        return bookRepository.findByName(name);
    }

    @Override
    public List<Book> findByNameContaining(String name)
    {
        return bookRepository.findByNameContaining(name);
    }

}
