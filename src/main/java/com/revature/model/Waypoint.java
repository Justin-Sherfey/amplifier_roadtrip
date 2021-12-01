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

    @Column(nullable = false)
    private double longitude;
    @Column(nullable = false)
    private double latitude;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="trip_id", nullable=false)
    private Trip trip;


}
