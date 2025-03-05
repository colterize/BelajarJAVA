package com.example.helloWorld.controller;


import com.example.helloWorld.TestPrint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestPrint testPrint;

    @PostMapping("/helloworld")
    public String manggil () {
        return testPrint.bebas();
    }
}
