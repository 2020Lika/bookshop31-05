package com.ma.Bookshop.controller;

import com.ma.Bookshop.ValidationException;
import com.ma.Bookshop.dto.BooksDto;
import com.ma.Bookshop.service.BooksService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
@Log

public class BooksController {
    private final BooksService booksService;

    @PostMapping("/save")
    public BooksDto saveBooks(@RequestBody BooksDto booksDto) throws ValidationException {
        log.info("Handling save books: " + booksDto);
        return booksService.saveUser(booksDto);
    }

    @GetMapping("/findAll")
    public List<BooksDto> findAllBooks() {
        log.info("Handling find all books request");
        return booksService.findAll();
    }

    @GetMapping("/findByName")
    public BooksDto findByName(@RequestParam String Name) {
        String name = null;
        log.info("Handling find by name request: " + null);
        return booksService.findByName(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBooks(@PathVariable Integer id) {
        log.info("Handling delete books request: " + id);
        booksService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
