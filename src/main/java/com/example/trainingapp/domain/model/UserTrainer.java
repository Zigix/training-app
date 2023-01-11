package com.example.trainingapp.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_trainer")
public class UserTrainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Diet> diets;

    @OneToMany
    private List<Training> trainings;

    @OneToOne
    private User user;

    @OneToOne
    private User trainer;
}
