package com.revature.Amplifire_RoadTrip;

import com.revature.model.User;
import com.revature.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountsTest {
    // ACCOUNTS TESTS

    @Test
    void testRegisterNewUser() {
        User user = new User("evan", "password", null);
        User userReturn = AccountService.registerNewUser(user);
        assertEquals(user.getUsername(), userReturn.getUsername());
    }

    @Test
    void testValidateLoginCredentials() {
        User user = new User("justin", "password", null);
        AccountService.registerNewUser(user);
        assertEquals(user.getUsername(), AccountService.validateLoginCredentials(user).getUsername());
    }

    @Test
    void testInvalidLogin() {
        User user = new User("user100", "password", null);
        User falseUser = new User("user100", "pass", null);
        AccountService.registerNewUser(user);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            AccountService.validateLoginCredentials(falseUser);
        });
        assertNotEquals(null , exception);
    }

    @Test
    void testRegisterExistingUser() {
        User user = new User("user101", "password", null);
        User user2 = new User("user101", "passwor", null);

        AccountService.registerNewUser(user);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            AccountService.registerNewUser(user2);
        });

        assertNotEquals(null, exception);
    }

    @Test
    void testNullUser() {
        User user = new User(null, null, null);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            AccountService.registerNewUser(user);
        });
        assertNotEquals(null, exception);
    }
}
