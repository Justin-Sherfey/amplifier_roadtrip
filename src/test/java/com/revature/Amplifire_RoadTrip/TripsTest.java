package com.revature.Amplifire_RoadTrip;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.revature.controller.TripController;
import com.revature.service.TripService;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TripController.class)
public class TripsTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private TripService tripService;

    //User user = new User("justin", "qwerty1234", null);

    /*
    @Test
    public void createUser() throws Exception {
        when(userService.createNewUser(user)).thenReturn(user);

        this.mockMvc.perform(post("/users/create"));
    }
    */
}
