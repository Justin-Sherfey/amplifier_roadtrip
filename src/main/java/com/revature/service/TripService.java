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

    public Trip createTrip(Trip trip){
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }


    public Trip getTripById(Integer tripId) {
        return tripRepository.getByTripId(tripId);
    }
}
