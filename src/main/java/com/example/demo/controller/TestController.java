package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${app.message}")
    private String welcomeMessage;

    @GetMapping("/test")
    public String test() {
        return welcomeMessage;
    }
}
