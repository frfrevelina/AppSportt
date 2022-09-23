package com.example.appsport.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.FileInputStream;
import java.sql.Blob;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Exercise {
    @Id
    private Integer id;
    private String title;
    private String repetitions;
    private String type;
    private byte[] image;

}
