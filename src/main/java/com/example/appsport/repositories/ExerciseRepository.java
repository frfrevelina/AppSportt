package com.example.appsport.repositories;

import com.example.appsport.entities.Exercise;
import com.example.appsport.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ExerciseRepository extends CrudRepository<Exercise, String> {
    Exercise findById(Integer id);
    List<Exercise> findAll();
}
