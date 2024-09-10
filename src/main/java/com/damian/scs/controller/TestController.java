package com.damian.scs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/test")
@CrossOrigin
@RequiredArgsConstructor
public class TestController {
    private final StreamBridge streamBridge;


    @GetMapping(path = "/hello")
    public String hello() {
        streamBridge.send("scs-publisher", "Hello World!");
        return "Event Published!";
    }
}
