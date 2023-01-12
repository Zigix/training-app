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
public class DietDto {
    private Long id;
    private String kcal;
    private String fat;
    private String proteins;
    private String carbon;
    private String dishes;
    private Date date;
    private Long userTrainerId;
}
