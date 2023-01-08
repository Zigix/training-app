package com.example.trainingapp.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "trainer_details")
@Data
public class TrainerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String description;

    @OneToOne
    private User trainer;
}
