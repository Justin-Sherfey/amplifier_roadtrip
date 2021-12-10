package com.revature.controller;

import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.security.util.JwtUtil;

import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling users using URI requests and communicating with the service layer
 */
@RestController()
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    /**
     * Constructor for creating a new UserController
     * @param userService the userservice instance
     * @param jwtUtil used for security and authentication
     */
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    /**
     * Handles a GET request, retrieves a user from the database using service layer and authenticating with a
     * generated token for security
     * @param incomingToken the authentication token to make sure user is logged in successfully
     * @return the user object if authentication succeeds
     */
    @GetMapping
    public User getUserByToken(@RequestHeader("Authorization") String incomingToken) {
        String token = incomingToken.substring(7);
        return userService.getUserByUsername(jwtUtil.extractUsername(token));
    }

    /**
     * Handles a PUT request and updates a user using the service layer
     * @param user the user to be updated if it exists
     * @return user object if successfully updated in the database
     */
    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * Handles a DELETE request and calls the service layer to delete the object from the database by user id
     * @param userId the user id of the user requesting to be deleted
     * @return boolean corresponding to whether the deletion was successful
     */
    @DeleteMapping("{userId}")
    public boolean deleteUserById(@PathVariable String userId) {
        return userService.deleteUserById(Integer.parseInt(userId));
    }

}
