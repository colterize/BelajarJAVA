package com.example.helloWorld;

import org.springframework.stereotype.Service;

@Service
public class Greetings {

    public String hello() {
        return "Hi ";
    }
}
