package com.example.appsport.entities;

import com.example.appsport.entities.compositeKey.UserExerciseCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.IdClass;
import javax.persistence.Id;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(UserExerciseCompositeKey.class)

public class UserExercise {
    @Id
    private Integer userId;
    @Id
    private Integer exerciseId;
}
