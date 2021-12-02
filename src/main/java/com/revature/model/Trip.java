package com.revature.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.AUTO,generator="trip_generator")
    @SequenceGenerator(name="trip_generator", sequenceName = "trip_seq")
    private int tripId;

    @Column
    private String tripName;
    @OneToMany(mappedBy="trip")
    @JsonManagedReference
    private List<Waypoint> waypoints;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id", nullable=false)
    @JsonBackReference
    private User user;



}
