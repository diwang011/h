package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Author;
import com.example.service.IAuthorService;

@RestController
@RequestMapping(value = "/author")
public class AuthorController
{
    @Autowired
    private IAuthorService authorService;

    @RequestMapping(value = "/")
    public List<Author> getAuthors()
    {
        return authorService.findAll();
    }

    @RequestMapping(value = "/getAuthorByName/{name}")
    public Author getAuthorByName(@PathVariable String name)
    {
        Author author = authorService.findByName(name);
        return author;
    }

    @RequestMapping(value = "/getAuthorByNameContaining/{name}")
    public List<Author> getAuthorByNameContaining(@PathVariable String name)
    {
        List<Author> authors = authorService.findByNameContaining(name);
        return authors;
    }

}
