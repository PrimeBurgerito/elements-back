package com.elements.elementsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"com.elements"}, exclude = {MongoAutoConfiguration.class})
public class ElementsApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElementsApiApplication.class, args);
    }
}
