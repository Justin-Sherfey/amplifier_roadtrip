package com.revature.Amplifire_RoadTrip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.revature.model.User;
import com.revature.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UsersTest {

    // USER TESTS
    @Test
    void testCreateNewUser() {
        User user = new User("isaiah", "password", null);
        assertEquals(user.getUsername(), UserService.createNewUser(user).getUsername());
    }

    @Test
    void testCreateExistingUser() {
        User user = new User("isaiah2", "pass", null);
        UserService.createNewUser(user);
        User user2 = new User("isaiah2", "qwerty123", null);
        assertEquals(null, UserService.createNewUser(user2));
    }

    @Test
    void testGetUserById() {
        User user = new User("noah", "password", null);
        User returningUser = UserService.createNewUser(user);
        assertEquals(user.getUsername(), UserService.getUserById(returningUser.getUserId()).getUsername());
    }

    @Test
    void testUpdateUser() {
        User user = new User("user1", "password", null);
        UserService.createNewUser(user);
        user.setPassword("password3");
        User returnedUser = UserService.updateUser(user);
        assertEquals("password3", returnedUser.getPassword());
    }

    @Test
    void testDeleteUserById() {
        User user = new User("user2", "password", null);
        user = UserService.createNewUser(user);
        boolean success = UserService.deleteUserById(user.getUserId());
        assertEquals(true, success);
        assertEquals(null, UserService.getUserById(user.getUserId()));
    }

}
