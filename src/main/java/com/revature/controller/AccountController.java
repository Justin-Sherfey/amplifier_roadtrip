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

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.security.InvalidAlgorithmParameterException;

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


    //TODO @RequestBody might be a bad exposure, but I don't know if we've learned best practice yet.

    @PostMapping(value = "/register")
    public User registerNewUser(@RequestBody User user) {
        return accountService.registerNewUser(user);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        }catch(BadCredentialsException e){
            System.out.println("invalid");
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
