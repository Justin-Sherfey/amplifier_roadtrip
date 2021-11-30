package com.revature.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tripId;

    @OneToMany(mappedBy="entireTrip")
    @JsonManagedReference
    List<Waypoint> waypoints;



}
