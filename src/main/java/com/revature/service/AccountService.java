package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private UserRepository userRepository;

    public AccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validateLoginCredentials(User user) {

        // returns true if the user exists and the passwords match
        return (userRepository.findByUsername(user.getUsername()) != null
                && userRepository.findByUsername(user.getUsername()).getPassword().equals(user.getPassword()))
                        ? userRepository.findByUsername(user.getUsername())
                        : null;
    }

    public User registerNewUser(User user) {

        // returns true if the user doesn't already exist
        return (userRepository.findByUsername(user.getUsername()) == null) ? userRepository.save(user) : null;
    }

}
