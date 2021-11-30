package com.revature.model;

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
}
