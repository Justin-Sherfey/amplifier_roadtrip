package com.revature.service;

import com.revature.model.*;
import com.revature.repository.TripRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Communicates with repository and controller layers to perform CRUD functionality for Trip objects and
 * persist to data
 */
@Service
public class TripService {
    private static TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    /**
     *
     * @param trip
     * @return
     */
    public static Trip createTrip(Trip trip){
        return tripRepository.save(trip);
    }

    /**
     *
     * @param userId
     * @return
     */
    public static List<Trip> getAllTripsById(Integer userId) {
        return tripRepository.findAllByUser_UserId(userId);
    }

    /**
     *
     * @param tripId
     * @return
     */
    public static Trip getTripById(Integer tripId) {
        return tripRepository.getByTripId(tripId);
    }

    /**
     *
     * @param trip
     * @return
     */
    public static Trip updateTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    /**
     *
     * @param tripId
     * @return
     */
    public static boolean deleteTripById(Integer tripId) {
        if(tripRepository.existsById(tripId)){
            tripRepository.deleteById(tripId);
            return true;
        }
        return false;
    }

}
