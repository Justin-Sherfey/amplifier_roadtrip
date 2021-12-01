package com.revature.controller;

import java.util.List;

import com.revature.model.Waypoint;
import com.revature.service.WaypointService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController()
@RequestMapping(value = "/waypoints")
public class WaypointController {

    private WaypointService waypointService;

    public WaypointController(WaypointService waypointService) {
        this.waypointService = waypointService;
    }


    //CREATE
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    @ResponseBody
    public Waypoint createWaypoint(@RequestBody Waypoint waypoint){
        return waypointService.createWaypoint(waypoint);
    }
    //READ
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{waypointId}")
    @ResponseBody
    public Waypoint getWaypointById(@PathVariable String waypointId){
        return waypointService.getWaypointById(Integer.parseInt(waypointId));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAll/{tripId}")
    @ResponseBody
    public List<Waypoint> getAllWaypointsById(@PathVariable String tripId) {
        return waypointService.getAllWaypointsById(Integer.parseInt(tripId));
    }


    @CrossOrigin(origins = "http://localhost:3000")
    //UPDATE
    @PostMapping("/update")
    @ResponseBody
    public Waypoint updateWaypoint(@RequestBody Waypoint waypoint){
        return waypointService.updateWaypoint(waypoint);
    }
    //DELETE
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{waypointId}")
    @ResponseBody
    public boolean deleteWaypointById(@PathVariable String waypointId){
        return waypointService.deleteWaypointById(Integer.parseInt(waypointId));
    }
}
