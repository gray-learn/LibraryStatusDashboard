package com.gray.borrowingservice;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class BorrowController {

    private final IBookClient bookClient;

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

    public String homepage(){
        return  "/index.html";
    }

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
