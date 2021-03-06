package com.revature.Amplifire_RoadTrip;

import com.revature.model.Trip;
import com.revature.model.User;
import com.revature.model.Waypoint;
import com.revature.service.TripService;
import com.revature.service.UserService;
import com.revature.service.WaypointService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests waypoint service layer
 */
@SpringBootTest
public class WaypointsTest {

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    @Autowired
    private WaypointService waypointService;

    /**
     * Tests creating a new waypoint
     */
    @Test
    void testCreateWaypoint() {
        User user = new User("user 8", "password", null);
        user = userService.createNewUser(user);
        Trip trip = new Trip("roadtrip8", user);
        trip = tripService.createTrip(trip);
        Waypoint waypoint = new Waypoint("waypoint 1", "test", trip);
        assertEquals(waypoint.getWaypointName(), waypointService.createWaypoint(waypoint).getWaypointName());
    }

    /**
     * Tests getting all the waypoints by a trip id
     */
    @Test
    void testGetAllWaypointsById() {
        User user = new User("user 9", "password", null);
        user = userService.createNewUser(user);
        Trip trip = new Trip("roadtrip9", user);
        trip = tripService.createTrip(trip);
        Waypoint waypoint = new Waypoint("waypoint 2","test", trip);
        Waypoint waypoint2 = new Waypoint("waypoint 3", "test", trip);
        waypointService.createWaypoint(waypoint);
        waypointService.createWaypoint(waypoint2);

        List<Waypoint> listWaypoints = waypointService.getAllWaypointsById(trip.getTripId());

        assertEquals(waypoint.getWaypointName(), listWaypoints.get(0).getWaypointName());
        assertEquals(waypoint2.getWaypointName(), listWaypoints.get(1).getWaypointName());
    }

    /**
     * Tests getting a singular waypoint using a waypoint id
     */
    @Test
    void testGetWaypointById() {
        User user = new User("user 10", "password", null);
        user = userService.createNewUser(user);
        Trip trip = new Trip("road trip 10", user);
        trip = tripService.createTrip(trip);

        Waypoint waypoint = new Waypoint("waypoint 4", "test", trip);
        waypoint = waypointService.createWaypoint(waypoint);

        assertEquals(waypoint.getWaypointName(),
                waypointService.getWaypointById(waypoint.getWaypointId()).getWaypointName());
    }

    /**
     * Tests updating a waypoint
     *
     * @Test
     *       void testUpdateWaypoint() {
     *       User user = new User("user 11", "password", null);
     *       user = UserService.createNewUser(user);
     *       Trip trip = new Trip("road trip 11", user);
     *       trip = TripService.createTrip(trip);
     * 
     *       Waypoint waypoint = new Waypoint("waypoint 5", 50.0, 50.0, trip);
     *       waypoint = WaypointService.createWaypoint(waypoint);
     * 
     *       waypoint.setLatitude(60.0);
     *       waypoint = WaypointService.updateWaypoint(waypoint);
     * 
     *       assertEquals(60.0, waypoint.getLatitude());
     *       }
     * 
     *       /**
     *       Tests deleting a waypoint using an id
     */
    @Test
    void testDeleteWaypointById() {
        User user = new User("user 12", "password", null);
        user = userService.createNewUser(user);
        Trip trip = new Trip("road trip 12", user);
        trip = tripService.createTrip(trip);

        Waypoint waypoint = new Waypoint("waypoint 6", "test", trip);
        waypoint = waypointService.createWaypoint(waypoint);

        boolean success = waypointService.deleteWaypointById(waypoint.getWaypointId());
        assertEquals(true, success);
        assertEquals(null, waypointService.getWaypointById(waypoint.getWaypointId()));
    }
}
