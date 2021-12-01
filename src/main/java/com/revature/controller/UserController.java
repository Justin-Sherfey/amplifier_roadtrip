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

<<<<<<< HEAD
    @PostMapping("/create")
    @ResponseBody
    public User createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }
    @GetMapping
    @ResponseBody
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(Integer.parseInt(userId));
=======
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
>>>>>>> 91eb4c9dc9d2cdb120b5d8b638c3ed671bba46cd
    }

}
