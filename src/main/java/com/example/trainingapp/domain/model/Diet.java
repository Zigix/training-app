package com.example.trainingapp.domain.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "diet")
@Getter
@Setter
@Builder
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kcal;
    private String fat;
    private String proteins;
    private String carbon;
    private String dishes;
    private Date date;

    @ManyToOne
    private UserTrainer userTrainer;
}
