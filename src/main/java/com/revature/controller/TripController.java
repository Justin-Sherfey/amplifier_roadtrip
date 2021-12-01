package com.revature.controller;

import java.util.List;

import com.revature.model.Trip;
import com.revature.model.Waypoint;
import com.revature.service.TripService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController()
@RequestMapping(value = "/trips")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }
    //CREATE
    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/create")
    @ResponseBody
    public Trip createTrip(@RequestBody Trip trip){
        return tripService.createTrip(trip);
    }

    //READ
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/{tripId}")
    @ResponseBody
    public Trip getTripById(@PathVariable String tripId){
        return tripService.getTripById(Integer.parseInt(tripId));
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/getAll/{userId}")
    @ResponseBody
    public List<Trip> getAllTripsById(@PathVariable String userId) {
        return tripService.getAllTripsById(Integer.parseInt(userId));
    }

    //UPDATE
    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/update")
    @ResponseBody
    public Trip updateTrip(@RequestBody Trip trip){
        return tripService.updateTrip(trip);
    }
    //DELETE

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/{tripId}")
    @ResponseBody
    public boolean deleteTripById(@PathVariable String tripId){
        return tripService.deleteTripById(Integer.parseInt(tripId));
    }

}
