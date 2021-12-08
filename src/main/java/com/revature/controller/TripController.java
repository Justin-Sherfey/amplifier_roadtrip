package com.revature.controller;

import java.util.List;

import com.revature.model.Trip;
import com.revature.service.TripService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    // CREATE
    @PostMapping
    @ResponseBody
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    // READ
    @GetMapping("/{tripId}")
    @ResponseBody
    public Trip getTripById(@PathVariable String tripId) {
        return tripService.getTripById(Integer.parseInt(tripId));
    }

    @GetMapping("/getAll/{userId}")
    @ResponseBody
    public List<Trip> getAllTripsById(@PathVariable String userId) {
        return tripService.getAllTripsById(Integer.parseInt(userId));
    }

    // UPDATE
    @PutMapping
    @ResponseBody
    public Trip updateTrip(@RequestBody Trip trip) {
        return tripService.updateTrip(trip);
    }

    // DELETE
    @DeleteMapping("/{tripId}")
    @ResponseBody
    public boolean deleteTripById(@PathVariable String tripId) {
        return tripService.deleteTripById(Integer.parseInt(tripId));
    }

}
