package com.revature.controller;

import java.util.List;

import com.revature.model.Waypoint;
import com.revature.service.WaypointService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/waypoint")
public class WaypointController {

    private WaypointService waypointService;

    public WaypointController(WaypointService waypointService) {
        this.waypointService = waypointService;
    }

    @GetMapping
    public List<Waypoint> getAllWaypoints() {
        return waypointService.getAllWaypoints();
    }

}
