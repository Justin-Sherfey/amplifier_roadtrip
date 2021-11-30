package com.revature.model;

import lombok.*;
import javax.persistence.*;

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
}
