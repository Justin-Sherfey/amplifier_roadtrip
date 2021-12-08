package com.revature.service;

import com.revature.model.*;
import com.revature.repository.TripRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    private static TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    //CREATE
    public static Trip createTrip(Trip trip){
        return tripRepository.save(trip);
    }

    //READ
    public static List<Trip> getAllTripsById(Integer userId) {
        return tripRepository.findAllByUser_UserId(userId);
    }

    public static Trip getTripById(Integer tripId) {
        return tripRepository.getByTripId(tripId);
    }

    //UPDATE
    public static Trip updateTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    //DELETE
    public static boolean deleteTripById(Integer tripId) {
        if(tripRepository.existsById(tripId)){
            tripRepository.deleteById(tripId);
            return true;
        }
        return false;
    }

}
