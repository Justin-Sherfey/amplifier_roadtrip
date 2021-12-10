package com.revature.Amplifire_RoadTrip;

import com.revature.model.Trip;
import com.revature.model.User;
import com.revature.model.Waypoint;
import com.revature.service.TripService;
import com.revature.service.UserService;
import com.revature.service.WaypointService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests waypoint service layer
 */
@SpringBootTest
public class WaypointsTest {

    /**
     * Tests creating a new waypoint
     */
    @Test
    void testCreateWaypoint() {
        User user = new User("user 8", "password", null);
        user = UserService.createNewUser(user);
        Trip trip = new Trip("roadtrip8", user);
        trip = TripService.createTrip(trip);
        Waypoint waypoint = new Waypoint("waypoint 1", 10.0, 10.0, trip);
        assertEquals(waypoint.getWaypointName(), WaypointService.createWaypoint(waypoint).getWaypointName());
    }

    /**
     * Tests getting all the waypoints by a trip id
     */
    @Test
    void testGetAllWaypointsById() {
        User user = new User("user 9", "password", null);
        user = UserService.createNewUser(user);
        Trip trip = new Trip("roadtrip9", user);
        trip = TripService.createTrip(trip);
        Waypoint waypoint = new Waypoint("waypoint 2", 10.0, 10.0, trip);
        Waypoint waypoint2 = new Waypoint("waypoint 3", 20.0, 20.0, trip);
        WaypointService.createWaypoint(waypoint);
        WaypointService.createWaypoint(waypoint2);

        List<Waypoint> listWaypoints = WaypointService.getAllWaypointsById(trip.getTripId());

        assertEquals(waypoint.getWaypointName(), listWaypoints.get(0).getWaypointName());
        assertEquals(waypoint2.getWaypointName(), listWaypoints.get(1).getWaypointName());
    }

    /**
     * Tests getting a singular waypoint using a waypoint id
     */
    @Test
    void testGetWaypointById() {
        User user = new User("user 10", "password", null);
        user = UserService.createNewUser(user);
        Trip trip = new Trip("road trip 10", user);
        trip = TripService.createTrip(trip);

        Waypoint waypoint = new Waypoint("waypoint 4", 40.0, 40.0, trip);
        waypoint = WaypointService.createWaypoint(waypoint);

        assertEquals(waypoint.getWaypointName(),
                WaypointService.getWaypointById(waypoint.getWaypointId()).getWaypointName());
    }

    /**
     * Tests updating a waypoint
     *
    @Test
    void testUpdateWaypoint() {
        User user = new User("user 11", "password", null);
        user = UserService.createNewUser(user);
        Trip trip = new Trip("road trip 11", user);
        trip = TripService.createTrip(trip);

        Waypoint waypoint = new Waypoint("waypoint 5", 50.0, 50.0, trip);
        waypoint = WaypointService.createWaypoint(waypoint);

        waypoint.setLatitude(60.0);
        waypoint = WaypointService.updateWaypoint(waypoint);

        assertEquals(60.0, waypoint.getLatitude());
    }

    /**
     * Tests deleting a waypoint using an id
     */
    @Test
    void testDeleteWaypointById() {
        User user = new User("user 12", "password", null);
        user = UserService.createNewUser(user);
        Trip trip = new Trip("road trip 12", user);
        trip = TripService.createTrip(trip);

        Waypoint waypoint = new Waypoint("waypoint 6", 60.0, 60.0, trip);
        waypoint = WaypointService.createWaypoint(waypoint);

        boolean success = WaypointService.deleteWaypointById(waypoint.getWaypointId());
        assertEquals(true, success);
        assertEquals(null, WaypointService.getWaypointById(waypoint.getWaypointId()));
    }
}
