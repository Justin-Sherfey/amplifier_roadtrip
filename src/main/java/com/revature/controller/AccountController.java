package com.revature.controller;

import com.revature.model.User;
import com.revature.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 
     * registerNewUser() and validateLoginCredentials() return
     * Users if the operation was successful, and null if not. This is not final,
     * and needs to be replaced once we figure out how the frontend recieves and
     * handles responses from the API.
     * 
     * null for registerNewUser() currently means the user already exists.
     * null for validateLoginCredentials() means the username or password was
     * incorrect.
     * 
     */
    @PostMapping(value = "/register")
    public User registerNewUser(@RequestBody User user) {
        return accountService.registerNewUser(user);
    }

    @PostMapping(value = "/login")
    public User validateLoginCredentials(@RequestBody User user) {
        return accountService.validateLoginCredentials(user);
    }
}
