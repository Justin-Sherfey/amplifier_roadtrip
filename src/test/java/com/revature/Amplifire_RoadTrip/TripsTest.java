package com.revature.Amplifire_RoadTrip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.revature.model.Trip;
import com.revature.model.User;
import com.revature.service.TripService;
import com.revature.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
public class TripsTest {

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


}
