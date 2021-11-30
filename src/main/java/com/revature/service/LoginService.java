package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String validateUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            if (userRepository.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())) {
                return "Password correct!";
            }
            return "Password incorrect!";
        }
        return "User not found! Please try again!";
    }
}
