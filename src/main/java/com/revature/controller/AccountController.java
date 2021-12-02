package com.revature.controller;

import com.revature.model.User;
import com.revature.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidAlgorithmParameterException;

@RestController()
@RequestMapping
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //TODO @RequestBody might be a bad exposure, but I don't know if we've learned best practice yet.

    @PostMapping(value = "/register")
    public User registerNewUser(@RequestBody User user) {
        return accountService.registerNewUser(user);
    }

    @PostMapping(value = "/login")
    public User validateLoginCredentials(@RequestBody User user) {
        return accountService.validateLoginCredentials(user);
    }
}
