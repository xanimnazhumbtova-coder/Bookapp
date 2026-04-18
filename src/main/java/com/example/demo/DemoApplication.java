package com.example.demo;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner(AuthorRepository repository) {
        return args -> {
            Author author = new Author();
            author.setName("Robert Greene");
            repository.save(author);
        };
    }
}
