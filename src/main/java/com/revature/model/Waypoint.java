package com.revature.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "waypoints")
public class Waypoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "waypoint_generator")
    @SequenceGenerator(name = "waypoint_generator", sequenceName = "waypoint_seq")
    private int waypointId;

    @Column
    private String waypointName;
    @Column(nullable = false)
    private double longitude;
    @Column(nullable = false)
    private double latitude;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "trip_id", nullable = false)
    @JsonBackReference
    private Trip trip;

    public Waypoint(String waypointName, double longitude, double latitude, Trip trip) {
        this.waypointName = waypointName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.trip = trip;
    }
}
