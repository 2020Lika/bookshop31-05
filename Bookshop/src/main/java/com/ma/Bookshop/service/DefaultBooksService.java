package com.ma.Bookshop.service;

import com.ma.Bookshop.ValidationException;
import com.ma.Bookshop.dto.BooksDto;
import com.ma.Bookshop.entity.Book;
import com.ma.Bookshop.repository.BooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@AllArgsConstructor
public class DefaultBooksService implements BooksService {
    
    private final BooksRepository booksRepository;
    private final BooksConverter booksConverter;

    @Override
    public BooksDto saveBook(BooksDto booksDto) throws ValidationException {
        validateBookDto(booksDto);
        Book.Books savedBook = booksRepository.save(booksConverter.fromBookDtoToBook(booksDto));
        return booksConverter.fromBookToBookDto(savedBook);
    }

    private void validateBookDto(BooksDto booksDto) throws ValidationException {
        if (isNull(booksDto)) {
            throw new ValidationException("Object book is null");
        }
    }

    private boolean isNull(BooksDto booksDto) {
        return Objects.isNull(booksDto);
    }

    @Override
    public void deleteBook(Integer bookId) {
        booksRepository.deleteById(bookId);
    }

    @Override
    public BooksDto findByName(String name) {
        Book.Books books = booksRepository.findByName(name);
        if (books != null) {
            return booksConverter.fromBookToBookDto(books);
        }
        return null;
    }

    @Override
    public List<BooksDto> findAll() {
        return StreamSupport.stream(booksRepository.findAll().spliterator(), false)
                .map(booksConverter::fromBookToBookDto)
                .collect(Collectors.toList());
    }

}
