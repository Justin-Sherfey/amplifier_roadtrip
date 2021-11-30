package com.revature.service;

// Spring Stereotypes
// @Component - general use annotation to wire up a class as an annotation
// @Service - more specific annotation to wire up a Service
// @Controller - specific annotation to wire up a Controller (Servlet)
// @Repository - specific annotation to wire up a Repository (DAO)

import com.revature.model.User;
import com.revature.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User validateUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null && userRepository.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())) {
            return userRepository.findByUsername(user.getUsername());
        }
        return null;
    }
}