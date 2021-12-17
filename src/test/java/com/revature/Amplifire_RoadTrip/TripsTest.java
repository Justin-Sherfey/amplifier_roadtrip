package com.revature.Amplifire_RoadTrip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.revature.model.Trip;
import com.revature.model.User;
import com.revature.service.TripService;
import com.revature.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Testing trips service layer
 */
@SpringBootTest
public class TripsTest {

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    /**
     * Testing creating a new trip
     */
    @Test
    void testCreateTrip() {
        User user = new User("user 3", "password", null);
        user = userService.createNewUser(user);
        Trip trip = new Trip("roadtrip", user);
        Trip newTrip = tripService.createTrip(trip);
        assertEquals(trip.getTripName(), newTrip.getTripName());

        userService.deleteUserById(user.getUserId());
        tripService.deleteTripById(newTrip.getTripId());
    }

    /**
     * Testing getting all the trips belonging to a user
     */
    @Test
    void testGetAllTripsById() {
        User user = new User("user 4", "password", null);
        user = userService.createNewUser(user);
        Trip trip1 = new Trip("roadtrip1", user);
        Trip trip2 = new Trip("roadtrip2", user);
        Trip trip3 = new Trip("roadtrip3", user);

        trip1 = tripService.createTrip(trip1);
        trip2 = tripService.createTrip(trip2);
        trip3 = tripService.createTrip(trip3);

        List<Trip> returnedTrips = tripService.getAllTripsById(user.getUserId());

        assertEquals(trip1.getTripName(), returnedTrips.get(0).getTripName());
        assertEquals(trip2.getTripName(), returnedTrips.get(1).getTripName());
        assertEquals(trip3.getTripName(), returnedTrips.get(2).getTripName());

        userService.deleteUserById(user.getUserId());
        tripService.deleteTripById(trip1.getTripId());
        tripService.deleteTripById(trip2.getTripId());
        tripService.deleteTripById(trip3.getTripId());

    }

    /**
     * Testing getting a trip by its identifying trip id
     */
    @Test
    void testGetTripById() {
        User user = new User("user 5", "password", null);
        user = userService.createNewUser(user);
        Trip trip = new Trip("roadtrip4", user);
        trip = tripService.createTrip(trip);
        assertEquals(trip.getTripName(), tripService.getTripById(trip.getTripId()).getTripName());
    }

    /**
     * Testing updating an existing trip
     *
     * @Test
     *       void testUpdateTrip() {
     *       User user = new User("user 6", "password", null);
     *       user = UserService.createNewUser(user);
     *       Trip trip = new Trip("roadtrip5", user);
     *       trip = TripService.createTrip(trip);
     *       trip.setTripName("roadtrip6");
     *       Trip returnedTrip = TripService.updateTrip(trip);
     *       assertEquals("roadtrip6", returnedTrip.getTripName());
     * 
     *       //UserService.deleteUserById(user.getUserId());
     *       //TripService.deleteTripById(returnedTrip.getTripId());
     *       }
     * 
     *       /**
     *       Testing deleting a trip
     */
    @Test
    void testDeleteTripById() {
        User user = new User("user 7", "password", null);
        user = userService.createNewUser(user);
        Trip trip = new Trip("roadtrip7", user);
        trip = tripService.createTrip(trip);
        boolean success = tripService.deleteTripById(trip.getTripId());
        assertEquals(true, success);
        assertEquals(null, tripService.getTripById(trip.getTripId()));

        userService.deleteUserById(user.getUserId());
    }

}
