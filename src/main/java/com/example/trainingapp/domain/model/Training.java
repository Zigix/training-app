package com.example.trainingapp.domain.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "trainings")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String workout;
}
