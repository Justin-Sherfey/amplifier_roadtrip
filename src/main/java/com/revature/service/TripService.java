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

    //CREATE
    public Trip createTrip(Trip trip){
        return tripRepository.save(trip);
    }

//    //READ
//    public List<Trip> getAllTripsById(Integer userId) {
//        return tripRepository.findAllByUser_user_id(userId);
//    }

    public Trip getTripById(Integer tripId) {
        return tripRepository.getByTripId(tripId);
    }

    //UPDATE
    //DELETE
}
