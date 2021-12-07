package com.revature.Amplifire_RoadTrip;

import com.revature.controller.AccountController;
import com.revature.controller.TripController;
import com.revature.controller.UserController;
import com.revature.controller.WaypointController;
import com.revature.model.Trip;
import com.revature.model.User;
import com.revature.service.AccountService;
import com.revature.service.TripService;
import com.revature.service.UserService;
import com.revature.service.WaypointService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

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
	public AccountService accountService;
	public TripService tripService;
	public WaypointService waypointService;

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

	// USER TESTS
	@Test
	void testCreateNewUser() {
		User user = new User("isaiah", "password", null);
		assertEquals(user.getUsername(), UserService.createNewUser(user).getUsername());
	}

	@Test
	void testGetUserById() {
		User user = new User("noah", "password", null);
		User returningUser = UserService.createNewUser(user);
		assertEquals(user.getUsername(), UserService.getUserById(returningUser.getUserId()).getUsername());
	}

	@Test
	void testUpdateUser() {
		User user = new User("user1", "password", null);
		UserService.createNewUser(user);
		user.setPassword("password3");
		User returnedUser = UserService.updateUser(user);
		assertEquals("password3", returnedUser.getPassword());
	}

	@Test
	void testDeleteUserById() {
		User user = new User("user2", "password", null);
		user = UserService.createNewUser(user);
		boolean success = UserService.deleteUserById(user.getUserId());
		assertEquals(true, success);
		assertEquals(null, UserService.getUserById(user.getUserId()));
	}

	// TRIP TESTS
	@Test
	void testCreateTrip() {
		User user = new User("user 3", "password", null);
		user = UserService.createNewUser(user);
		Trip trip = new Trip("roadtrip", user);
		assertEquals(trip.getTripName(), TripService.createTrip(trip).getTripName());
	}

	@Test
	void testGetAllTripsById() {
		User user = new User("user 4", "password", null);
		user = UserService.createNewUser(user);
		Trip trip1 = new Trip("roadtrip1", user);
		Trip trip2 = new Trip("roadtrip2", user);
		Trip trip3 = new Trip("roadtrip3", user);

		TripService.createTrip(trip1);
		TripService.createTrip(trip2);
		TripService.createTrip(trip3);

		List<Trip> returnedTrips = TripService.getAllTripsById(user.getUserId());

		assertEquals(trip1.getTripName(), returnedTrips.get(0).getTripName());
		assertEquals(trip2.getTripName(), returnedTrips.get(1).getTripName());
		assertEquals(trip3.getTripName(), returnedTrips.get(2).getTripName());
	}

	@Test
	void testGetTripById() {
		User user = new User("user 5", "password", null);
		user = UserService.createNewUser(user);
		Trip trip = new Trip("roadtrip4", user);
		trip = TripService.createTrip(trip);
		assertEquals(trip.getTripName(), TripService.getTripById(trip.getTripId()).getTripName());
	}

	@Test
	void testUpdateTrip() {
		User user = new User("user 6", "password", null);
		user = UserService.createNewUser(user);
		Trip trip = new Trip("roadtrip5", user);
		trip = TripService.createTrip(trip);
		trip.setTripName("roadtrip6");
		Trip returnedTrip = TripService.updateTrip(trip);
		assertEquals("roadtrip6", returnedTrip.getTripName());
	}

	@Test
	void testDeleteTripById() {
		User user = new User("user 7", "password", null);
		user = UserService.createNewUser(user);
		Trip trip = new Trip("roadtrip7", user);
		trip = TripService.createTrip(trip);
		boolean success = TripService.deleteTripById(trip.getTripId());
		assertEquals(true, success);
		assertEquals(null, TripService.getTripById(trip.getTripId()));
	}

	@Test
	void testCreateWaypoint() {

	}
}
