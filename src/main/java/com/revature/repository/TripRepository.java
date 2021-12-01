package com.revature.repository;

import com.revature.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
    Trip getByTripId(Integer tripId);

//    List<Trip> findAllByUser_user_id(Integer userId);
}