package com.gray.bookservice;


import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

//@Component
//@AllArgsConstructor

@Configuration
@EntityScan(basePackageClasses = {com.gray.bookservice.Book.class})
@EnableJpaRepositories(basePackageClasses = {com.gray.bookservice.IBookRespository.class})
public class DBSeeder {

    @Bean
    CommandLineRunner initDatabase(IBookRespository repository) {
        return args -> {
            repository.save(new Book(0L, "The Hobbit", "1234567890123","AVAILABLE"));
            repository.save(new Book(0L, "1984", "1234567890124","AVAILABLE"));
            repository.save(new Book(0L, "The Catcher in the Rye", "1234567890125","AVAILABLE"));
            repository.save(new Book(0L, "Wanna Rich?", "1234567890125","BORROWED"));

            // add more books as needed
        };
    }
}



//public class DBSeeder implements CommandLineRunner {
//
////    @Bean
////    CommandLineRunner initDBSeeder(IBookRespository reposotry)
//
//    private final IBookRespository bookRespository;
//    @Override
//    public void run(String... args)throws Exception{
//        List<Book> bookList =List.of(
//                Book.builder().id(0L).name("The Hobbit").isbn(UUID.randomUUID().toString()).build(),
//                Book.builder().id(0L).name("1984").isbn(UUID.randomUUID().toString()).build(),
//                Book.builder().id(0L).name("The Catcher in the Rye").isbn(UUID.randomUUID().toString()).build()
//
//
////                            repository.save(new Book(0L, "The Hobbit", "1234567890123"));
////            repository.save(new Book(0L, "1984", "1234567890124"));
////            repository.save(new Book(0L, "The Catcher in the Rye", "1234567890125"));
//        );
//
//        bookRespository.saveAll(bookList);
////        bookRespository.saveAll(movies);
////        bookRespository.findAll().forEach((movie ->
////                {
////                        System.out.println(movie.getId()+ "   "+movie.getName());
////                        System.out.println( "=ISBN ==   "+movie.getIsbn());
////                }
////        ));
//    }
//
//}
