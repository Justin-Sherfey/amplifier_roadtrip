package com.revature.model;

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

    @Column
    private String tripName;

    @OneToMany(mappedBy="trip")
    private List<Waypoint> waypoints;
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name="user_id", nullable=false)
//    private User user;



}
