package com.ma.Bookshop.repository;

import com.ma.Bookshop.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Book.Books, Integer> {

    Book.Books findByName(String name);
}
