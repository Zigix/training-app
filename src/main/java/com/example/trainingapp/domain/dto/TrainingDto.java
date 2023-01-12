package com.example.trainingapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDto {
    private Long id;
    private Date date;
    private String workout;
    private boolean done;
    private Long userTrainerId;
}
