package com.revature.service;

import com.revature.model.User;
import com.revature.model.exception.InvalidCredentialsException;
import com.revature.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private static UserRepository userRepository;

    public AccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO both these methods should eventually implement JWT response tokens and ResponseEntity<?>

    /**
     * Check that input credentials are a valid match w/in the DataBase
     * @param user a user object that must contain at least a username and password
     * @return the matching user on the database if the credentials are valid
     */
    public static User validateLoginCredentials(User user) {
        User returningUser = userRepository
                .findByUsername(user.getUsername())
                .orElseThrow(InvalidCredentialsException::new);//username couldn't be found

        if(user.getPassword().equals(returningUser.getPassword()))
            return returningUser; //valid username and password
        else
            throw new InvalidCredentialsException();
            //username was found but password didn't match
    }

    /**
     * if the username doesn't already exist, add it into the database
     * @param user a user supplied by client side containing a new password and (potentially) new username
     * @return the newly registered user if it's a valid login
     */
    public static User registerNewUser(User user) {
        if(user.getUsername() == null || user.getPassword() == null)
            throw new InvalidCredentialsException(); //user needs both a username and password to register

        if(userRepository.existsByUsername(user.getUsername()))
            throw new InvalidCredentialsException();//username collision
        else
            userRepository.save(user); //there wasn't a username collision, so we can save the new user.

        return userRepository.getUserByUsername(user.getUsername());//guaranteed since we saved it.
    }

}
