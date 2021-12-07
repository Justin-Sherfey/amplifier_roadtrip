package com.revature.Amplifire_RoadTrip;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.revature.controller.UserController;
import com.revature.model.User;
import com.revature.service.UserService;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
public class UsersTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    User user = new User("justin", "qwerty1234", null);

    @Test
    public void createUser() throws Exception {
        when(userService.createNewUser(user)).thenReturn(user);

        this.mockMvc.perform(post("/users/create"));
    }

}
