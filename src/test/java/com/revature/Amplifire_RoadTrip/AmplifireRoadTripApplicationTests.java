package com.revature.Amplifire_RoadTrip;

import com.revature.controller.AccountController;
import com.revature.controller.TripController;
import com.revature.controller.UserController;
import com.revature.controller.WaypointController;
import com.revature.model.User;
import com.revature.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;




/**
 * Testing service layer
*/
@SpringBootTest
@AutoConfigureMockMvc
class AmplifireRoadTripApplicationTests {


	@Autowired
	private AccountController accountController;

	@Autowired
	private TripController tripController;

	@Autowired
	private UserController userController;

	@Autowired
	private WaypointController waypointController;

	@Autowired
	private MockMvc mockMvc;

	public UserService userService;

	@Test
	void accountContextLoads() throws Exception {
		assertThat(accountController).isNotNull();
	}

	@Test
	void tripContextLoads() throws Exception {
		assertThat(tripController).isNotNull();
	}

	@Test
	void userContextLoads() throws Exception {
		assertThat(userController).isNotNull();
	}

	@Test
	void waypointContextLoads() throws Exception {
		assertThat(waypointController).isNotNull();
	}

	@Test
	public void testCreateUser() throws Exception {
		User user = new User("Ryan", "qwerty1234", null);
		assertNotEquals(null, userService.createNewUser(user));
	}

	@Test
	public void testGetUser() throws Exception {
		User user2 = new User("Jackson", "qwerty1234", null);
		userService.createNewUser(user2);
		assertNotEquals(null, userService.getUserById(1));
	}

	@Test
	public void testDeleteUser() throws Exception {
		User user3 = new User("Miles", "qwerty1234", null);
		userService.createNewUser(user3);
		assertNotEquals(null, userService.getUserById(1));
		userService.deleteUserById(1);
		assertNull(userService.getUserById(1));
	}

}
