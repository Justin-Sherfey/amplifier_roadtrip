package com.revature.controller;

import java.util.List;

import com.revature.model.User;
import com.revature.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController()
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //CREATE
    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/create")
    @ResponseBody
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    //READ
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/{userId}")
    @ResponseBody
    public User getUserById(@PathVariable String userId) {
        return userService.getUserById(Integer.parseInt(userId));
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
