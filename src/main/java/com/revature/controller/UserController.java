package com.revature.controller;

import com.revature.model.User;
import com.revature.security.util.JwtUtil;
import com.revature.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;


    //CREATE
    @PostMapping("/create")
    @ResponseBody
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    //READ
    @GetMapping
    @ResponseBody
    public User getUserByToken(@RequestHeader("Authorization") String token) {
        return userService.getUserByUsername(jwtUtil.extractUsername(token));
    }

    //UPDATE
    @PostMapping("/update")
    @ResponseBody
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    //DELETE
    @DeleteMapping("/userId")
    @ResponseBody
    public boolean deleteUserById(@PathVariable String userId){
        return userService.deleteUserById(Integer.parseInt(userId));
    }

}
