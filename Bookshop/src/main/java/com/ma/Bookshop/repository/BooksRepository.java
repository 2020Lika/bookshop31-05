package com.ma.Bookshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository<Books> extends JpaRepository<Books, Integer> {

    Books findByName(String name);
}
