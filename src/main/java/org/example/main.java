package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class main {

    //public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        User.loadDataFromFile();
        SpringApplication.run(main.class, args);
    }

}
