package com.revature.service;

import com.revature.model.*;
import com.revature.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    private TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public List<Waypoint> getWayPointById(Integer tripId){
        return tripRepository.getAllWaypointById(tripId);
    }


}
