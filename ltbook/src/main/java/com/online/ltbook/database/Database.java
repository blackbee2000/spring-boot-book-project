package com.online.ltbook.database;


import com.online.ltbook.repositories.BlogRepository;
import com.online.ltbook.repositories.BookRepository;
import com.online.ltbook.repositories.CartRepository;
import com.online.ltbook.repositories.ProductCartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabaseBook(BookRepository bookRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            }
        };
    }

    @Bean
    CommandLineRunner initDatabaseBlog(BlogRepository blogRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            }
        };
    }

    @Bean
    CommandLineRunner initDatabaseProductCart(ProductCartRepository productCartRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            }
        };
    }

    @Bean
    CommandLineRunner initDatabaseCart(CartRepository cartRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            }
        };
    }
}
