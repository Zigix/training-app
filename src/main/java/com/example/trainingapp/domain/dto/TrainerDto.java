package com.example.trainingapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerDto {
    private Long trainerId;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String description;
}
