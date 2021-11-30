package com.revature.repository;

import com.revature.model.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaypointRepository extends JpaRepository<Waypoint, Integer> {

}
