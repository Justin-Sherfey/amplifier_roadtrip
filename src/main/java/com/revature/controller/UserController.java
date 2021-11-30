package com.revature.controller;

import java.util.List;

import com.revature.model.User;
import com.revature.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createNewUser(User user) {
        return userService.createNewUser(user);
    }

}
