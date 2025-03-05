package com.example.helloWorld.controller;

import com.example.helloWorld.Greetings;
import com.example.helloWorld.dto.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingsController {

    private final Greetings greetings;

    @PostMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return greetings.hello() + name;
    }

    @PostMapping("/greet")
    public String greet(@RequestBody Profile profile) {
        return greetings.hello() + profile.getFirstName() + " " + profile.getLastName() ;
    }
}
