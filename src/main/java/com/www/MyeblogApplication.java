package com.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyeblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyeblogApplication.class, args);
        System.out.println("http://localhost:9090/");
    }

}
