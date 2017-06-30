package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Author;
import com.example.repository.AuthorRepository;
import com.example.service.IAuthorService;

@Service
@Transactional
public class AuthorServiceImpl implements IAuthorService
{
    @Autowired
    private AuthorRepository authorRepository;
    
    @Override
    public List<Author> findAll()
    {
        return authorRepository.findAll();
    }

    @Override
    public Author findByName(String name)
    {
        return authorRepository.findByName(name);
    }

    @Override
    public List<Author> findByNameContaining(String name)
    {
        return authorRepository.findByNameContaining(name);
    }

}
