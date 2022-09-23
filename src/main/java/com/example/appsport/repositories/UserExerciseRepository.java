package com.example.appsport.repositories;

import com.example.appsport.entities.UserExercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserExerciseRepository extends CrudRepository<UserExercise, String> {
    List<UserExercise> findByUserId(Integer userId);
    List<UserExercise> findAll();
}
