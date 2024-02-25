package com.gray.borrowingservice;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private  long id;
    private String name;
    private String isbn;
    private String status; // Assuming status is a String
}
