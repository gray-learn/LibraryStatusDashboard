package com.gray.bookservice;


import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {com.gray.bookservice.Book.class})
@EnableJpaRepositories(basePackageClasses = {com.gray.bookservice.IBookRespository.class})
public class DBSeeder {
// Marks this class as configuration class which defines beans and settings for the Spring context.
//    @Configuration
// Specifies the packages to scan for entities. This is useful when entities are not located in the main application package or its subpackages.
//    @EntityScan(basePackageClasses = {com.gray.bookservice.Book.class})
// Enables Spring Data JPA repositories. It also configures the base package to scan for JPA repository interfaces.
//    @EnableJpaRepositories(basePackageClasses = {com.gray.bookservice.IBookRespository.class})

    @Bean    // Defines a bean that implements CommandLineRunner. This bean will run the code within its run method after the application context is loaded.
    CommandLineRunner initDatabase(IBookRespository repository) {
        return args -> {
            repository.save(new Book(0L, "How to Be Old: Lessons in Living Boldly from the Accidental Icon", "9780593471791","AVAILABLE"));

        };
    }
}


