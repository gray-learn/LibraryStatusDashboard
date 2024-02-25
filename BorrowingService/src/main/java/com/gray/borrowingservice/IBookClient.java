package com.gray.borrowingservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("book-service")
public interface IBookClient {

    @GetMapping("books")
    public List<Book> getBooks();

    @GetMapping("availableBooks")
    public List<Book> getAvailableBooks();

    @GetMapping("borrowedBooks")
    public List<Book> getBorrowBooks();



    @PostMapping("books/{id}")
    public Book getBookById(Long id) ;
}
