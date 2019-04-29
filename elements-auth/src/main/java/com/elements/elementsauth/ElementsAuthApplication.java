package com.elements.elementsauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.elements"})
public class ElementsAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElementsAuthApplication.class, args);
    }

}
