package com.elements.elementsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;


@SpringBootApplication(
        scanBasePackages = {"com.elements"},
        exclude = {MongoAutoConfiguration.class, MongoReactiveAutoConfiguration.class}
)
public class ElementsApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElementsApiApplication.class, args);
    }
}
