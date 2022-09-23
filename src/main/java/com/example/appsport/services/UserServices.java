package com.example.appsport.services;

import com.example.appsport.entities.User;
import com.example.appsport.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServices {
    @Autowired
    UserRepository userRepository;
    public UserServices(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void createUser(User user) {

        userRepository.save(user);

    }

    public User verifyUser(User userLoginRequest) throws Exception {

      User foundUser =  this.userRepository.findByUsernameAndPassword(userLoginRequest.getUsername(), userLoginRequest.getPassword());
       if(foundUser==null){throw new Exception("User or password is not correct");}
        return foundUser;
    }



}
