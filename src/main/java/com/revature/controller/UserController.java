package com.revature.controller;

import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.security.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // READ
    @GetMapping
    public User getUserByToken(@RequestHeader("Authorization") String incomingToken) {
        String token = incomingToken.substring(7);
        return userService.getUserByUsername(jwtUtil.extractUsername(token));
    }

    // UPDATE
    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    // DELETE
    @DeleteMapping("{userId}")
    public boolean deleteUserById(@PathVariable String userId) {
        return userService.deleteUserById(Integer.parseInt(userId));
    }

}
