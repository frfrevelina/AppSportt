package com.example.appsport.services;

import com.example.appsport.entities.Weight;
import com.example.appsport.repositories.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class WeightService {
    WeightRepository weightRepository;

    @Autowired
    public WeightService(WeightRepository weightRepository){
        this.weightRepository = weightRepository;
    }

    public void progress (Weight weight)
    {
       this.weightRepository.save(weight);
    }

    public List<Weight> findByUserId(Integer userId) throws Exception {
        return this.weightRepository.findByUserId(userId);
    }
}
