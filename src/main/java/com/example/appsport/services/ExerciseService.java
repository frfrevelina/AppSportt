package com.example.appsport.services;

import com.example.appsport.entities.Exercise;
import com.example.appsport.entities.User;
import com.example.appsport.entities.UserExercise;
import com.example.appsport.repositories.ExerciseRepository;
import com.example.appsport.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;
    public ExerciseService(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }
    public Exercise GetExerciseById(Integer id) throws Exception {
        Exercise exercise =  this.exerciseRepository.findById(id);
        return exercise;
    }

    public List<Exercise> GetAllExercises() throws Exception{
        List<Exercise> exercises = this.exerciseRepository.findAll();
        return exercises;
    }
}
