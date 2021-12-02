package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //CREATE
    public User createNewUser(User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            return null; //TODO perhaps throw exception???
        return userRepository.save(user);
    }

    //READ
    public User getUserById(Integer userId) {
        return userRepository.getUserByUserId(userId);
    }

    //UPDATE
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    //DELETE
    public boolean deleteUserById(Integer userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}