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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int waypointId;

    @Column
    private String waypointName;
    @Column(nullable = false)
    private double longitude;
    @Column(nullable = false)
    private double latitude;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="trip_id", nullable=false)
    @JsonBackReference
    private Trip trip;


}
