package com.gray.borrowingservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Defines a Feign client interface to interact with the book-service.
// The "book-service" argument specifies the name of the microservice this client will communicate with.
@FeignClient("book-service")
public interface IBookClient {

    @GetMapping("books")
    public List<Book> getBooks();// Defines a method to fetch a list of books from the book-service.

    @GetMapping("availableBooks")
    public List<Book> getAvailableBooks();

    @GetMapping("borrowedBooks")
    public List<Book> getBorrowBooks();

    @PostMapping("books/{id}")
    public Book getBookById(Long id) ;
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id);
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable("id") Long id) ;

    @PostMapping("add")
    public ResponseEntity<String> addBook(@RequestBody Book book);
}
