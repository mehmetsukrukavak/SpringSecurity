package com.mehmetsukrukavak.SpringSecurity.controller;

import com.mehmetsukrukavak.SpringSecurity.model.User;
import com.mehmetsukrukavak.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.saveUser(user);

    }
}
