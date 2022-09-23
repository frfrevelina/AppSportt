package com.example.appsport.repositories;

import com.example.appsport.entities.UserExercise;
import com.example.appsport.entities.Weight;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository

public interface WeightRepository extends CrudRepository<Weight, Integer>{

    List<Weight> findByUserId(Integer userId);

}

