package com.example.trainingapp.service;

import com.example.trainingapp.domain.model.User;
import com.example.trainingapp.domain.model.UserTrainer;
import com.example.trainingapp.repository.TrainerDetailsRepository;
import com.example.trainingapp.repository.UserRepository;
import com.example.trainingapp.repository.UserTrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTrainerService {
    private final UserTrainerRepository userTrainerRepository;
    private final UserRepository userRepository;

    public UserTrainer connectUserWithTrainer(Long trainerId, User loggedUser) {
        UserTrainer userTrainer = UserTrainer.builder()
                .user(loggedUser)
                .trainer(userRepository.getById(trainerId))
                .build();
        return userTrainerRepository.save(userTrainer);
    }
}
