package com.revature.controller;

import java.util.List;

import com.revature.model.User;
import com.revature.service.UserService;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD

=======
<<<<<<< HEAD
/**
 * User login test
 *
 */
=======
>>>>>>> 03f0d320bf608315f37e4f90620e2a7fe96e6943
>>>>>>> feature-login
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
<<<<<<< HEAD


=======
>>>>>>> feature-login
}
