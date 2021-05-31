package com.ma.Bookshop.service;

import com.ma.Bookshop.dto.BooksDto;
import com.ma.Bookshop.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BooksConverter {

        public Book.Books fromBookDtoToBook(BooksDto booksDto) {
            Book.Books books = new Book.Books();
            books.setId(booksDto.getId());
            books.setName(booksDto.getName());
            books.setTitle(booksDto.getTitle());
            books.setAuthor(booksDto.getAuthor());
            books.setPrice(booksDto.getPrice());
            return books;
        }

    public BooksDto fromBookToBookDto(Book.Books books) {
        return BooksDto.builder()
                .id(books.getId())
                .name(books.getName())
                .title(books.getTitle())
                .author(books.getAuthor())
                .price(books.getPrice())
                .build();
    }

/*
    public Object fromBookToBookDto() {
    }

    public Object fromBookToBookDto(Object o) {
    }
*/
}

