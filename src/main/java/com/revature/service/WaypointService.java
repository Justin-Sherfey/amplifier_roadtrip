package com.revature.service;

import java.util.List;

import com.revature.model.Waypoint;
import com.revature.repository.WaypointRepository;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class WaypointService {

    private static WaypointRepository waypointRepository;

    public WaypointService(WaypointRepository userRepository) {
        this.waypointRepository = userRepository;
    }

    /**
     *
     * @param waypoint
     * @return
     */
    public static Waypoint createWaypoint(Waypoint waypoint) {
        return waypointRepository.save(waypoint);
    }

    /**
     *
     * @param tripId
     * @return
     */
    public static List<Waypoint> getAllWaypointsById(Integer tripId) {
        return waypointRepository.findAllByTrip_TripId(tripId);
    }

    /**
     *
     * @param waypointId
     * @return
     */
    public static Waypoint getWaypointById(Integer waypointId) {
        return waypointRepository.getByWaypointId(waypointId);
    }

    /**
     *
     * @param waypoint
     * @return
     */
    public static Waypoint updateWaypoint(Waypoint waypoint){
        return waypointRepository.save(waypoint);
    }

    /**
     *
     * @param waypointId
     * @return
     */
    public static boolean deleteWaypointById(Integer waypointId){
        if(waypointRepository.existsById(waypointId)) {
            waypointRepository.deleteById(waypointId);
            return true;
        }
        return false;
    }
}
