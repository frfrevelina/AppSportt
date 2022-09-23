package com.example.appsport.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ExerciseOutput {
    private String title;
    private String repetitions;
    private String type;
    private String image;

}
