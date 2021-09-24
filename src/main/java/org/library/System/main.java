package org.library.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
class System {
    public static void main(String[] args) {
        SpringApplication.run(System.class, args);
    }
}
