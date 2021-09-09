package org.library.System;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
class System implements CommandLineRunner{
    private static final Logger Log = LoggerFactory.getLogger(System.class);
    public static void main(String[] args) {
        SpringApplication.run(System.class, args);
    }
    @Value("${application.name")
    private String applicationName;
    @Value("${username}")
    private String username;
    @Override
    public void run(String... args) throws Exception {
        Log.info("Application name {},Username:{}",applicationName,username);

    }
}
