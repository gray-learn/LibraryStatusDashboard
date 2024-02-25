package com.gray.bookservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookRespository extends JpaRepository<Book, Long> {
    List<Book> findByStatus(String status);
}
