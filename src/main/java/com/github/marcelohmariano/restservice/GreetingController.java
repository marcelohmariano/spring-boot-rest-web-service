package com.github.marcelohmariano.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(
        @RequestParam(name = "name", defaultValue = "World") String name
    ) {
        String content = String.format("Hello, %s!", name);
        long greetingId = counter.incrementAndGet();
        return new Greeting(greetingId, content);
    }
}
