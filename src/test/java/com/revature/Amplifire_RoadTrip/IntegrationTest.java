package com.revature.Amplifire_RoadTrip;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.AccountController;
import com.revature.controller.UserController;
import com.revature.model.User;
import com.revature.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration/end-to-end testing using Spring MockMVC
 */
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountController accountController;
    @Autowired
    private UserController userController;

    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Tests when a valid user attempts to login
     * @throws Exception
     */
    @Test
    public void validUser_loginToAccount() throws Exception {

        User user = new User();
        user.setUserId(1);
        user.setPassword("password");
        user.setUsername("just");
        user.setTrips(null);

        user = userRepository.save(user);

        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user))
                .accept(MediaType.APPLICATION_JSON))

                .andExpect(MockMvcResultMatchers.jsonPath("$.jwt").exists());
    }

    /**
     * Tests when user attempts to read user information without proper authentication
     * @throws Exception
     */
    @Test
    public void testGetUserID_withoutAuthentication() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setPassword("password");
        user.setUsername("just");
        user.setTrips(null);

        //user = userRepository.save(user);

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users/{userId}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(405));
    }
}
