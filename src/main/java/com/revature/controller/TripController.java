package com.revature.controller;

import java.util.List;

import com.revature.model.Trip;
import com.revature.model.Waypoint;
import com.revature.service.TripService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/trips")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    @ResponseBody
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping
    @ResponseBody
    public List<Waypoint> getWaypointsByID(Integer tripId){
        return tripService.getWayPointById(tripId);
    }

}
