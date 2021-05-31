package com.ma.Bookshop.service;

import com.ma.Bookshop.dto.BooksDto;

import java.util.List;

public interface BooksService {
    BooksDto saveUser(BooksDto booksDto);

    void deleteBook(Integer bookId);

    BooksDto findByName(String name);

    List<BooksDto> findAll();
}
