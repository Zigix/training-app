package com.example.trainingapp.service;

import com.example.trainingapp.domain.dto.DietDto;
import com.example.trainingapp.domain.dto.TrainingDto;
import com.example.trainingapp.domain.mapper.EntityDtoMapper;
import com.example.trainingapp.domain.model.Diet;
import com.example.trainingapp.domain.model.Training;
import com.example.trainingapp.domain.model.User;
import com.example.trainingapp.domain.model.UserTrainer;
import com.example.trainingapp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTrainerService {
    private final UserTrainerRepository userTrainerRepository;
    private final UserRepository userRepository;
    private final DietRepository dietRepository;
    private final TrainingRepository trainingRepository;
    private final EntityDtoMapper mapper;

    public UserTrainer connectUserWithTrainer(Long trainerId, User loggedUser) {
        UserTrainer userTrainer = UserTrainer.builder()
                .user(loggedUser)
                .trainer(userRepository.getById(trainerId))
                .build();
        return userTrainerRepository.save(userTrainer);
    }

    public void addDiet(DietDto dietDto) {
        Diet diet = mapper.toDiet(dietDto);
        dietRepository.save(diet);
    }

    public void addTraining(TrainingDto trainingDto) {
        Training training = mapper.toTraining(trainingDto);
        trainingRepository.save(training);
    }
}
