package com.revature.Amplifire_RoadTrip;

import com.revature.model.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Account service layer
 */
@SpringBootTest
public class AccountsTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    /**
     * Registering a new user with valid credentials
     */
    @Test
    void testRegisterNewUser() {
        User user = new User("evan", "password", null);
        User userReturn = accountService.registerNewUser(user);
        assertEquals(user.getUsername(), userReturn.getUsername());

        userService.deleteUserById(userReturn.getUserId());
    }

    /**
     * Logging in with valid login credentials
     */
    @Test
    void testValidateLoginCredentials() {
        User user = new User("justin", "password", null);
        User trueUser = new User("justin", "password", null);
        user = accountService.registerNewUser(user);
        ResponseEntity<?> loginReturn = accountService.loginUser(user);
        assertEquals(loginReturn.getStatusCode(), accountService.loginUser(trueUser).getStatusCode());

        userService.deleteUserById(user.getUserId());
    }

    /**
     * Testing if a user enters an invalid login with a bad password
     */
    @Test
    void testInvalidLogin() {
        User user = new User("user100", "password", null);
        User falseUser = new User("user100", "pass", null);
        user = accountService.registerNewUser(user);
        ResponseEntity<?> loginReturn = accountService.loginUser(user);

        assertNotEquals(loginReturn.getStatusCode(), accountService.loginUser(falseUser).getStatusCode());

        userService.deleteUserById(user.getUserId());
    }

    /**
     * Testing when a user tries to register with a username that already exists
     */
    @Test
    void testRegisterExistingUser() {
        User user = new User("user101", "password", null);
        User user2 = new User("user101", "passwor", null);

        user = accountService.registerNewUser(user);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            accountService.registerNewUser(user2);
        });
        assertNotEquals(null, exception);

        userService.deleteUserById(user.getUserId());
    }

    /**
     * Testing when the username and password are null
     */
    @Test
    void testNullUser() {
        User user = new User(null, null, null);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            accountService.registerNewUser(user);
        });
        assertNotEquals(null, exception);
    }
}
