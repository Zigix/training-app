package com.example.trainingapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerDetailsDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String description;
}
