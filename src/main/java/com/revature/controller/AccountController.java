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
     * 
     * registerNewUser() and validateLoginCredentials() return
     * Users if the operation was successful, and null if not. This is not final,
     * and needs to be replaced once we figure out how the frontend recieves and
     * handles responses from the API.
     * 
     * null for registerNewUser() currently means the user already exists.
     * null for validateLoginCredentials() means the username or password was
     * incorrect.
     * 
     */
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
