package com.elements.elementsapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SpringBootResourceController {
    @RequestMapping("/demo")
    public String demo(Principal principal) {
        return "Hello " + principal.getName() + ", Auth 2.0 Resource Server, Access Granted by authentication server..";
    }
}
