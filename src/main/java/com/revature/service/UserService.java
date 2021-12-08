package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // === CRUD methodology === //

    // CREATE
    public static User createNewUser(User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            return null; // TODO perhaps throw exception???
        return userRepository.save(user);
    }

    // READ
    public static User getUserById(Integer userId) {
        return userRepository.getUserByUserId(userId);
    }

    public static User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    //UPDATE
    public static User updateUser(User user) {
        return userRepository.save(user);
    }

    // DELETE
    public static boolean deleteUserById(Integer userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
