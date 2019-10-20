package com.elements.gamesession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(scanBasePackages = {"com.elements"})
public class GameSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameSessionApplication.class, args);
    }

}
