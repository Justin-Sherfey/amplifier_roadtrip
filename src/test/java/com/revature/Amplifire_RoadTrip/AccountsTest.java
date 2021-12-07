package com.revature.Amplifire_RoadTrip;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.AccountController;
import com.revature.model.User;
import com.revature.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test-application.properties")
public class AccountsTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountController accountController;

    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testRegisterNewUser() throws Exception {

        User user = new User("justin", "password", null);
        user = userRepository.save(user);

        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        //mockMvc.perform(Mock)

    }
}
