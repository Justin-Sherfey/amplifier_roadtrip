package com.revature.Amplifire_RoadTrip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.revature.model.User;
import com.revature.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Testing user service layer
 */
@SpringBootTest
public class UsersTest {

    @Autowired
    private UserService userService;

    /**
     * Tests creating a new user
     */
    @Test
    void testCreateNewUser() {
        User user = new User("isaiah", "password", null);
        assertEquals(user.getUsername(), userService.createNewUser(user).getUsername());
    }

    /**
     * Tests creating a new user when the username already exists
     */
    @Test
    void testCreateExistingUser() {
        User user = new User("isaiah2", "pass", null);
        userService.createNewUser(user);
        User user2 = new User("isaiah2", "qwerty123", null);
        assertEquals(null, userService.createNewUser(user2));
    }

    /**
     * Tests getting user information with a valid id
     */
    @Test
    void testGetUserById() {
        User user = new User("noah", "password", null);
        User returningUser = userService.createNewUser(user);
        assertEquals(user.getUsername(), userService.getUserById(returningUser.getUserId()).getUsername());
    }

    /**
     * Tests updating a user
     *
     * @Test
     *       void testUpdateUser() {
     *       User user = new User("user1", "password", null);
     *       UserService.createNewUser(user);
     *       user.setPassword("password3");
     *       User returnedUser = UserService.updateUser(user);
     *       assertEquals("password3", returnedUser.getPassword());
     *       }
     * 
     *       /**
     *       Tests deleting a user
     */
    @Test
    void testDeleteUserById() {
        User user = new User("user2", "password", null);
        user = userService.createNewUser(user);
        boolean success = userService.deleteUserById(user.getUserId());
        assertEquals(true, success);
        assertEquals(null, userService.getUserById(user.getUserId()));
    }

}
