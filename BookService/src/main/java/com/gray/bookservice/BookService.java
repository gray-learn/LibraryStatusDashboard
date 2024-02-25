package com.gray.bookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

//    @Autowired
    private final IBookRespository bookRepository;

    @Autowired
    public BookService(IBookRespository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAvaliableBooks() {
        return bookRepository.findByStatus("AVAILABLE");
    }

    public List<Book> getBorrowedBooks() {
        return bookRepository.findByStatus("BORROWED");
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book updateBookStatus(Long id, String status) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setStatus(status);
        return bookRepository.save(book);
    }

    public ResponseEntity<String> addBook(@RequestBody Book book){
        bookRepository.save(book);
        return ResponseEntity.ok("Book Added Successfully");
    }

    public ResponseEntity<String> deleteById(Long id){
        if(!bookRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Book Deleted");
    }

}
