package com.revature.Amplifire_RoadTrip;

import com.revature.controller.AccountController;
import com.revature.controller.TripController;
import com.revature.controller.UserController;
import com.revature.controller.WaypointController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing service layer
*/
@SpringBootTest
class ContextInitializationTest {

	@Autowired
	private AccountController accountController;

	@Autowired
	private TripController tripController;

	@Autowired
	private UserController userController;

	@Autowired
	private WaypointController waypointController;


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

}
