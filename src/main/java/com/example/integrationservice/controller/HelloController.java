package com.example.integrationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getWelcome() {
    	String message = "Welcome";
        return message;
    }
    
    
}
