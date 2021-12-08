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

    /**
     *
     * @param user
     * @return
     */
    public static User createNewUser(User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            return null;
        return userRepository.save(user);
    }

    /**
     *
     * @param userId
     * @return
     */
    public static User getUserById(Integer userId) {
        return userRepository.getUserByUserId(userId);
    }

    /**
     *
     * @param username
     * @return
     */
    public static User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }


    public static User updateUser(User user) {
        return userRepository.save(user);
    }

    /**
     *
     * @param userId
     * @return
     */
    public static boolean deleteUserById(Integer userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
