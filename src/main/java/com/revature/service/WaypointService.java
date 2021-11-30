package com.revature.service;

import java.util.List;

import com.revature.model.Waypoint;
import com.revature.repository.WaypointRepository;
import org.springframework.stereotype.Service;

@Service
public class WaypointService {

    private WaypointRepository waypointRepository;

    public WaypointService(WaypointRepository userRepository) {
        this.waypointRepository = userRepository;
    }

    public Waypoint createNewWaypoint(Waypoint waypoint) {
        return waypointRepository.save(waypoint);
    }

    public List<Waypoint> getAllWaypoints() {
        return waypointRepository.findAll();
    }

}
