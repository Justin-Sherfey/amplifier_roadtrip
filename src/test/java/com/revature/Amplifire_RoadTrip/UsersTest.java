package com.revature.Amplifire_RoadTrip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.revature.model.User;
import com.revature.service.UserService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Testing user service layer
 */
@SpringBootTest
public class UsersTest {

    /**
     * Tests creating a new user
     */
//    @Test
//    void testCreateNewUser() {
//        User user = new User("isaiah", "password", null);
//        assertEquals(user.getUsername(), UserService.createNewUser(user).getUsername());
//    }

    /**
     * Tests creating a new user when the username already exists
     */
    @Test
    void testCreateExistingUser() {
        User user = new User("isaiah2", "pass", null);
        UserService.createNewUser(user);
        User user2 = new User("isaiah2", "qwerty123", null);
        assertEquals(null, UserService.createNewUser(user2));
    }

    /**
     * Tests getting user information with a valid id
     */
//    @Test
//    void testGetUserById() {
//        User user = new User("noah", "password", null);
//        User returningUser = UserService.createNewUser(user);
//        assertEquals(user.getUsername(), UserService.getUserById(returningUser.getUserId()).getUsername());
//    }

    /**
     * Tests updating a user
     *
    @Test
    void testUpdateUser() {
        User user = new User("user1", "password", null);
        UserService.createNewUser(user);
        user.setPassword("password3");
        User returnedUser = UserService.updateUser(user);
        assertEquals("password3", returnedUser.getPassword());
    }

    /**
     * Tests deleting a user
     */
    @Test
    void testDeleteUserById() {
        User user = new User("user2", "password", null);
        user = UserService.createNewUser(user);
        boolean success = UserService.deleteUserById(user.getUserId());
        assertEquals(true, success);
        assertEquals(null, UserService.getUserById(user.getUserId()));
    }

}
