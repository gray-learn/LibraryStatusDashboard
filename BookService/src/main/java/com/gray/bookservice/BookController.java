package com.gray.bookservice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/availableBooks")
    public List<Book> getAllAvailableBooks() {
        return bookService.getAvaliableBooks();
    }

    @GetMapping("/borrowedBooks")
    public List<Book> getBorrowedBooks() {
        return bookService.getBorrowedBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        return bookService.deleteById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        return ResponseEntity.ok("Add book");
    }


}
