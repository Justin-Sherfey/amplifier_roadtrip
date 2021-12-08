package com.revature.Amplifire_RoadTrip;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.AccountController;
import com.revature.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountController accountController;

    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    /*
    @Test
    public void validUser_createNewAccount() throws Exception {
        User user = new User("user 1000", "password", null);

        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/trips")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("user 1000"));
    }

     */
}
