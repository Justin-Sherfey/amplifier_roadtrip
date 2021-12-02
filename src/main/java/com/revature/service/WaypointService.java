package com.revature.service;

import java.util.List;

import com.revature.model.Waypoint;
import com.revature.repository.WaypointRepository;
import org.springframework.stereotype.Service;

@Service
public class WaypointService {

    private final WaypointRepository waypointRepository;

    public WaypointService(WaypointRepository userRepository) {
        this.waypointRepository = userRepository;
    }

    //CREATE
    public Waypoint createWaypoint(Waypoint waypoint) {
        return waypointRepository.save(waypoint);
    }

    //READ
    public List<Waypoint> getAllWaypointsById(Integer tripId) {
        return waypointRepository.findAllByTrip_TripId(tripId);
    }

    public Waypoint getWaypointById(Integer waypointId) {
        return waypointRepository.getByWaypointId(waypointId);
    }

    //UPDATE
    public Waypoint updateWaypointById(Waypoint waypoint){
        return waypointRepository.save(waypoint);
    }

    //DELETE
    public boolean deleteWaypointById(Integer waypointId){
        if(waypointRepository.existsById(waypointId)) {
            waypointRepository.deleteById(waypointId);
            return true;
        }
        return false;
    }
}
