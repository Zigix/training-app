package com.example.trainingapp.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "trainings")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String workout;
    private boolean done;

    @ManyToOne
    private UserTrainer userTrainer;
}
