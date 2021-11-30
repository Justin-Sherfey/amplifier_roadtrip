package com.revature.controller;

import com.revature.model.User;

import com.revature.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/login")
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // to-do handle how frontend manages the response from validate users
    // currently gives frontend user and nothing else
    @PostMapping
    public User validateUser(@RequestBody User user) {
        return userService.validateUser(user);
    }
}
