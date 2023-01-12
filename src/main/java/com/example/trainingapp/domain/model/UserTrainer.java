package com.example.trainingapp.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user_trainer")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserTrainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "userTrainer")
    private List<Diet> diets;

    @OneToMany(mappedBy = "userTrainer")
    private List<Training> trainings;

    @OneToOne
    private User user;

    @OneToOne
    private User trainer;
}
