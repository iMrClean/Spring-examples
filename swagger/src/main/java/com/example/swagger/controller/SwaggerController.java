package com.example.swagger.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @GetMapping("/swagger")
    public ResponseEntity<Void> test1() {
	return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "/swagger-ui.html").build();
    }

    @GetMapping("/api/hello-swagger")
    public String sayHello() {
	return "Hello swagger";
    }
}
