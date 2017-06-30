package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>
{

    public Book findByName(String name);

    public List<Book> findByNameContaining(String name);

}
