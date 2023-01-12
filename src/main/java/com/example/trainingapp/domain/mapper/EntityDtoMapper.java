package com.example.trainingapp.domain.mapper;

import com.example.trainingapp.domain.dto.DietDto;
import com.example.trainingapp.domain.dto.TrainingDto;
import com.example.trainingapp.domain.dto.UserTrainerDto;
import com.example.trainingapp.domain.model.Diet;
import com.example.trainingapp.domain.model.Training;
import com.example.trainingapp.domain.model.User;
import com.example.trainingapp.domain.model.UserTrainer;
import com.example.trainingapp.repository.UserRepository;
import com.example.trainingapp.repository.UserTrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EntityDtoMapper {
    private final UserTrainerRepository userTrainerRepository;

    public DietDto toDietDto(Diet diet) {
        return DietDto.builder()
                .id(diet.getId())
                .kcal(diet.getKcal())
                .fat(diet.getFat())
                .proteins(diet.getProteins())
                .carbon(diet.getCarbon())
                .dishes(diet.getDishes())
                .date(diet.getDate())
                .userTrainerId(diet.getUserTrainer().getId())
                .build();
    }

    public Diet toDiet(DietDto dietDto) {
        return Diet.builder()
                .id(dietDto.getId())
                .kcal(dietDto.getKcal())
                .fat(dietDto.getFat())
                .proteins(dietDto.getProteins())
                .carbon(dietDto.getCarbon())
                .dishes(dietDto.getDishes())
                .date(dietDto.getDate())
                .userTrainer(userTrainerRepository.getById(dietDto.getId()))
                .build();
    }

    public TrainingDto toTrainingDto(Training training) {
        return TrainingDto.builder()
                .id(training.getId())
                .date(training.getDate())
                .workout(training.getWorkout())
                .done(training.isDone())
                .userTrainerId(training.getUserTrainer().getId())
                .build();
    }

    public Training toTraining(TrainingDto trainingDto) {
        return Training.builder()
                .id(trainingDto.getId())
                .date(trainingDto.getDate())
                .workout(trainingDto.getWorkout())
                .done(trainingDto.isDone())
                .userTrainer(userTrainerRepository.getById(trainingDto.getUserTrainerId()))
                .build();
    }

    public UserTrainer toUserTrainer(UserTrainerDto userTrainerDto) {
        return UserTrainer.builder()
                .id(userTrainerDto.getId())
                .diets(userTrainerDto.getDiets().stream().map(this::toDiet).collect(Collectors.toList()))
                .trainings(userTrainerDto.getTrainings().stream().map(this::toTraining).collect(Collectors.toList()))
                .user(userTrainerRepository.findByUserIdAndTrainerId(userTrainerDto.getUserId(), userTrainerDto.getTrainerId()).getUser())
                .trainer(userTrainerRepository.findByUserIdAndTrainerId(userTrainerDto.getUserId(), userTrainerDto.getTrainerId()).getTrainer())
                .build();
    }

    public UserTrainerDto toUserTrainerDto(UserTrainer userTrainer) {
        return UserTrainerDto.builder()
                .id(userTrainer.getId())
                .diets(userTrainer.getDiets().stream().map(this::toDietDto).collect(Collectors.toList()))
                .trainings(userTrainer.getTrainings().stream().map(this::toTrainingDto).collect(Collectors.toList()))
                .userId(userTrainer.getUser().getId())
                .trainerId(userTrainer.getTrainer().getId())
                .build();
    }
}
