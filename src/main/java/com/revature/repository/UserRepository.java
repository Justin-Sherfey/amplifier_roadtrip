package com.revature.repository;

import com.revature.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
<<<<<<< HEAD

    User getUserByUserId(Integer userId);
=======
    User findByUsername(String username);
>>>>>>> 91eb4c9dc9d2cdb120b5d8b638c3ed671bba46cd
}
