package com.revature.controller;

import java.util.List;

import com.revature.model.User;
import com.revature.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * User login test
 *
 */
@RestController()
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @ResponseBody
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }
    @GetMapping
    @ResponseBody
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(Integer.parseInt(userId));
    }

}
