package com.revature.repository;

import com.revature.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUserId(Integer userId);
    User getUserByUsername(String username);
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    User getUserByUsername(String username);
}
