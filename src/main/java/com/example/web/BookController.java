package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.service.IBookService;

@RestController
@RequestMapping(value = "/book")
public class BookController
{
    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/")
    public List<Book> getBooks()
    {
        return bookService.findAll();
    }

    @RequestMapping(value = "/getBookByName/{name}")
    public Book getBookByName(@PathVariable String name)
    {
        Book book = bookService.findByName(name);
        return book;
    }

    @RequestMapping(value = "/getBookByNameContaining/{name}")
    public List<Book> getBookByNameContaining(@PathVariable String name)
    {
        List<Book> books = bookService.findByNameContaining(name);
        return books;
    }

}
