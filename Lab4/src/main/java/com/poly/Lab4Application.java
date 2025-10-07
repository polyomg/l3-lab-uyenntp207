package com.poly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Lab4Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printIndexUrl() {
        System.out.println("🚀 LAB4 is running! Main page: http://localhost:8080/");
    }
}
