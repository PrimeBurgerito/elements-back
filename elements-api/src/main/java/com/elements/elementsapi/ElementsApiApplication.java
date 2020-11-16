package com.elements.elementsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.elements"})
public class ElementsApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElementsApiApplication.class, args);
    }
}
