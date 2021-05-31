package com.ma.Bookshop.service;

import com.ma.Bookshop.ValidationException;
import com.ma.Bookshop.dto.BooksDto;
import com.ma.Bookshop.entity.Book;
import com.ma.Bookshop.repository.BooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor

    public class DefaultBooksService implements BooksService {
    
    private final BooksRepository booksRepository;
    private final BooksConverter booksConverter;


    public BooksDto saveBook(BooksDto booksDto) throws ValidationException {
        validateBookDto(booksDto);
        Book.Books savedBook = (Book.Books) booksRepository.save(booksConverter.fromBookDtoToBook(booksDto));
        return (BooksDto) booksConverter.fromBookToBookDto();
    }

    private void validateBookDto(BooksDto booksDto) throws ValidationException {
        if (isNull(booksDto)) {
            throw new ValidationException("Object book is null");
        }
    }

    private boolean isNull(BooksDto booksDto) {
    }

    @Override
    public BooksDto saveUser(BooksDto booksDto) {
        return null;
    }

    @Override
    public void deleteBook(Integer bookId) {
        booksRepository.deleteById(bookId);
    }

    @Override
    public BooksDto findByName(String name) {
        DefaultBooksService booksRepository = null;
        assert booksRepository != null;
        BooksDto books = booksRepository.findByName(name);
        if (books != null) {
            return booksConverter.fromBookToBookDto(books);
        }
        return null;
    }

    @Override
    public List<BooksDto> findAll() {
        return (List<BooksDto>) booksRepository.findAll()
                .stream()
                .map(booksConverter::fromBookToBookDto)
                .collect(Collectors.toList());
    }

}
