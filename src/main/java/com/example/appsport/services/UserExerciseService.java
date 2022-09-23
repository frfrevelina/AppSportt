package com.example.appsport.services;

import com.example.appsport.entities.Exercise;
import com.example.appsport.entities.UserExercise;
import com.example.appsport.entities.Weight;
import com.example.appsport.repositories.UserExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Scope("singleton")
@Service

public class UserExerciseService {
    @Autowired
    UserExerciseRepository userExerciseRepository;



    public UserExerciseService(UserExerciseRepository userExerciseRepository) {
        this.userExerciseRepository = userExerciseRepository;

    }
    public void saveMyProgress (UserExercise userExercise)
    {
        this.userExerciseRepository.save(userExercise);
    }


    public List<UserExercise> GetUserExercises(Integer id) throws Exception {
        List<UserExercise> exercises = this.userExerciseRepository.findByUserId(id);
        return exercises;
    }

}






