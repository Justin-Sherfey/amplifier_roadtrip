package com.revature.controller;

import com.revature.model.User;
import com.revature.security.model.AuthenticationRequest;
import com.revature.security.model.AuthenticationResponse;
import com.revature.security.util.JwtUtil;
import com.revature.security.util.MyUserDetailsService;
import com.revature.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling HTTP requests concerning registering new accounts and logging in to existing accounts,
 * uses AccountService in order to persist data
 */
@RestController()
@RequestMapping
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


    /**
     * Parses register URI request and calls AccountService to register new user and persist to database
     * @param user user to be registered
     * @return registered user if successful
     */
    @PostMapping(value = "/register")
    public User registerNewUser(@RequestBody User user) {
        return accountService.registerNewUser(user);
    }

    /**
     * Takes in a login URI request and creates an authentication token for the front-end session authentication
     * @param authenticationRequest the authentication request that will verify the username and password
     * @return the authentication token to be used for verification in future requests
     * @throws Exception if username or password are not valid
     */
    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            System.out.println("invalid");
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
