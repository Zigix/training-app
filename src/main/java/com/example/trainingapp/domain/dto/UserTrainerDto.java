package com.example.trainingapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTrainerDto {
    private Long id;
    private List<DietDto> diets;
    private List<TrainingDto> trainings;
    private Long userId;
    private Long trainerId;
}
