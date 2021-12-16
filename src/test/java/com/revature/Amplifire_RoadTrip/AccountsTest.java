package com.revature.Amplifire_RoadTrip;

import com.revature.model.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Account service layer
 */
@SpringBootTest
public class AccountsTest {

    /**
     * Registering a new user with valid credentials
     */
//    @Test
//    void testRegisterNewUser() {
//        User user = new User("evan", "password", null);
//        User userReturn = AccountService.registerNewUser(user);
//        assertEquals(user.getUsername(), userReturn.getUsername());
//
//        UserService.deleteUserById(userReturn.getUserId());
//    }

    /**
     * Logging in with valid login credentials
     */
//    @Test
//    void testValidateLoginCredentials() {
//        User user = new User("justin", "password", null);
//        user = AccountService.registerNewUser(user);
//        assertEquals(user.getUsername(), AccountService.validateLoginCredentials(user).getUsername());
//
//        UserService.deleteUserById(user.getUserId());
//    }

    /**
     * Testing if a user enters an invalid login with a bad password
     */
    @Test
    void testInvalidLogin() {
        User user = new User("user100", "password", null);
        User falseUser = new User("user100", "pass", null);
        user = AccountService.registerNewUser(user);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            AccountService.validateLoginCredentials(falseUser);
        });
        assertNotEquals(null , exception);

        UserService.deleteUserById(user.getUserId());
    }

    /**
     * Testing when a user tries to register with a username that already exists
     */
    @Test
    void testRegisterExistingUser() {
        User user = new User("user101", "password", null);
        User user2 = new User("user101", "passwor", null);

        user = AccountService.registerNewUser(user);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            AccountService.registerNewUser(user2);
        });
        assertNotEquals(null, exception);

        UserService.deleteUserById(user.getUserId());
    }

    /**
     * Testing when the username and password are null
     */
    @Test
    void testNullUser() {
        User user = new User(null, null, null);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            AccountService.registerNewUser(user);
        });
        assertNotEquals(null, exception);
    }
}
