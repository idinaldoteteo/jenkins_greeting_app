package com.teteo.greeting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello World. This application is UP with Jenkins.");
    }

    @GetMapping("/jenkins")
    public ResponseEntity<String> jenkins() {
        return ResponseEntity.ok("Hello World. I am automated with Jenkins.");
    }

}
