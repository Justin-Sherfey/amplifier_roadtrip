package com.revature.controller;

import java.util.List;

import com.revature.model.Waypoint;
import com.revature.service.WaypointService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/waypoints")
public class WaypointController {

    private final WaypointService waypointService;

    public WaypointController(WaypointService waypointService) {
        this.waypointService = waypointService;
    }

    // CREATE
    @PostMapping
    public Waypoint createWaypoint(@RequestBody Waypoint waypoint) {
        return waypointService.createWaypoint(waypoint);
    }

    // READ
    @GetMapping("/{waypointId}")
    public Waypoint getWaypointById(@PathVariable String waypointId) {
        return waypointService.getWaypointById(Integer.parseInt(waypointId));
    }

    @GetMapping("/getAll/{tripId}")
    public List<Waypoint> getAllWaypointsById(@PathVariable String tripId) {
        return waypointService.getAllWaypointsById(Integer.parseInt(tripId));
    }

    // UPDATE
    @PutMapping
    public Waypoint updateWaypoint(@RequestBody Waypoint waypoint) {
        return waypointService.updateWaypoint(waypoint);
    }

    // DELETE
    @DeleteMapping("/{waypointId}")
    public boolean deleteWaypointById(@PathVariable String waypointId) {
        return waypointService.deleteWaypointById(Integer.parseInt(waypointId));
    }
}
