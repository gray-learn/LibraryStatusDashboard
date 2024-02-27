package com.gray.borrowingservice;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController // Marks this class as a REST controller, enabling it to handle HTTP requests.
@AllArgsConstructor// Lombok annotation to generate a constructor with one parameter for each field.
public class BorrowController {

    private final IBookClient bookClient; // Injects the IBookClient interface to communicate with the book service.

    @GetMapping("/books")
    public List<Book>getBookeList(){
        return  bookClient.getBooks();
    }
    @GetMapping("/availableBooks")
    public List<Book>getAvailableBooks(){
        return  bookClient.getAvailableBooks();
    }
    @GetMapping("/borrowedBooks")
    public List<Book>getBorrowBooks(){
        return  bookClient.getBorrowBooks();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        System.out.println("Deleting book with ID: " + id);
        // Here you should call the service method that will delete the book from the database
        return bookClient.deleteBookById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id){
        System.out.println("Updating book with ID: " + id);
        return  bookClient.updateBookById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        return  bookClient.addBook(book);
    }


    public String homepage(){
        return  "/index.html";
    }

    // Endpoint to redirect requests from /actuator/info to /dashboard.html.
    @GetMapping("/actuator/info")
    public void redirectToDashboard(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("REDIRECT URL="+ request.getRequestURL().toString());
            response.sendRedirect("/dashboard.html");
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Redirection failed", e);
        }
    }
}
