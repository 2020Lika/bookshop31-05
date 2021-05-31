package com.ma.Bookshop.service;

import com.ma.Bookshop.ValidationException;
import com.ma.Bookshop.dto.BooksDto;

import java.util.List;

public interface BooksService {
    BooksDto saveBook(BooksDto booksDto) throws ValidationException;

    void deleteBook(Integer bookId);

    BooksDto findByName(String name);

    List<BooksDto> findAll();
}
