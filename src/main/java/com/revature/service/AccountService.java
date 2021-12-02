package com.revature.service;

import com.revature.model.User;
import com.revature.model.exception.InvalidCredentialsException;
import com.revature.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final UserRepository userRepository;

    public AccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO these should both be eventually replaced by JWT response tokens and ResponseEntity<?>

    /**
     * Check that input credentials are a valid match w/in the DataBase
     * @param user a user object that must contain at least a username and password
     * @return the matching user on the database if the credentials are valid
     */
    public User validateLoginCredentials(User user) {
        User returningUser = userRepository
                .findByUsername(user.getUsername())
                .orElseThrow(InvalidCredentialsException::new);
                //username couldn't be found

        if(user.getPassword().equals(returningUser.getPassword()))
            return returningUser;
        else
            throw new InvalidCredentialsException();
            //username was found but password didn't match
    }

    /**
     * if the username doesn't already exist, add it into the database
     * @param user a user supplied by client side containing a new password and (potentially) new username
     * @return a registered user if it's a valid login
     */
    public User registerNewUser(User user) {
        return userRepository
                .findByUsername(user.getUsername())
                .orElseThrow(InvalidCredentialsException::new);
    }

}
