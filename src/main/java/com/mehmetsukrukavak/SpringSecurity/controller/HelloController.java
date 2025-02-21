package com.mehmetsukrukavak.SpringSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {

    @GetMapping("/hello")
    public String greeting(HttpServletRequest request) {
        return "Hello Security " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request) {
        return "About Security " + request.getSession().getId();
    }
}
