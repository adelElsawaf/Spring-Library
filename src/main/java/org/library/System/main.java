package org.library.System;

import org.library.System.books.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
class System {
    public static void main(String[] args) {
        SpringApplication.run(System.class, args);
    }
}
