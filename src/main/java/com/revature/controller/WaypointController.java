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


    //CREATE
    @PostMapping("/create")
    @ResponseBody
    public Waypoint createWaypoint(@RequestBody Waypoint waypoint){
        return waypointService.createWaypoint(waypoint);
    }
    //READ
    @GetMapping("/{waypointId}")
    @ResponseBody
    public Waypoint getWaypointById(@PathVariable String waypointId){
        return waypointService.getWaypointById(Integer.parseInt(waypointId));
    }

    @GetMapping("/getAll/{tripId}")
    @ResponseBody
    public List<Waypoint> getAllWaypointsById(@PathVariable String tripId) {
        return waypointService.getAllWaypointsById(Integer.parseInt(tripId));
    }


    //UPDATE
    @PostMapping("/update")
    @ResponseBody
    public Waypoint editWayPointByID(@RequestBody Waypoint waypoint){
        return waypointService.updateWaypointById(waypoint);
    }
    //DELETE
    @DeleteMapping("/{waypointId}")
    @ResponseBody
    public boolean deleteWaypointById(@PathVariable String waypointId){
        return waypointService.deleteWaypointById(Integer.parseInt(waypointId));
    }
}
