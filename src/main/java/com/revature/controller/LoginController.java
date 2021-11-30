package com.revature.controller;

import com.revature.model.User;
import com.revature.service.LoginService;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public String validateUser(@RequestBody User user) {
        return loginService.validateUser(user);

    }
}
