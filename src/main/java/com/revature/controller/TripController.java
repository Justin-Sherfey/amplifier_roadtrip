package com.revature.controller;

import java.util.List;

import com.revature.model.Trip;
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
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

}
