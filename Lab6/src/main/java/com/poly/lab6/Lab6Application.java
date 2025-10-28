package com.poly.lab6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.lab6.dao.CategoryDao;
import com.poly.lab6.dao.ProductDao;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication

// Test DAO
public class Lab6Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab6Application.class, args);
    }

    @GetMapping("")
    public String home() {
        return "home/index";
    }

//    @Bean
//    CommandLineRunner run(CategoryDao cdao, ProductDao pdao) {
//        return args -> {
//            System.out.println("Category count: " + cdao.count());
//            System.out.println("Product count: " + pdao.count());
//        };
//    }
}
