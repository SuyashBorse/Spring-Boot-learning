package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloControler {
    // --> /hello - Which method will be called.
    // --> /order - Which method will be called.

@GetMapping("hello")
    public String hello(){
      return "<h1>Hello World!<h1>";
    }
}
