package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>
{

    public Author findByName(String name);

    public List<Author> findByNameContaining(String name);

}
