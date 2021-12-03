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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_seq")
    private int userId;

    @Column(unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy="user")
    @JsonManagedReference
    private List<Trip> trips;


    public User(String username, String password, List<Trip> trips) {
        this.username = username;
        this.password = password;
        this.trips = trips;
    }

}
