package com.example.trainingapp.service;

import com.example.trainingapp.domain.dto.TrainerDetailsDto;
import com.example.trainingapp.domain.dto.TrainerDto;
import com.example.trainingapp.domain.model.TrainerDetails;
import com.example.trainingapp.domain.model.User;
import com.example.trainingapp.repository.TrainerDetailsRepository;
import com.example.trainingapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainerDetailsService {
    private final TrainerDetailsRepository trainerDetailsRepository;
    private final UserRepository userRepository;

    public TrainerDetails addTrainer(TrainerDetailsDto trainerDetailsDto, User user) {
        TrainerDetails trainerDetails = new TrainerDetails();
        trainerDetails.setFirstName(trainerDetailsDto.getFirstName());
        trainerDetails.setLastName(trainerDetailsDto.getLastName());
        trainerDetails.setPhoneNumber(trainerDetailsDto.getPhoneNumber());
        trainerDetails.setDescription(trainerDetailsDto.getDescription());
        trainerDetails.setTrainer(user);
        user.setTrainer(true);
        userRepository.save(user);
        return trainerDetailsRepository.save(trainerDetails);
    }

    public List<TrainerDto> getTrainers() {
        return trainerDetailsRepository.findAll().stream()
                .map(trainerDetails ->
                        TrainerDto.builder()
                        .trainerId(trainerDetails.getTrainer().getId())
                        .email(trainerDetails.getTrainer().getEmail())
                        .username(trainerDetails.getTrainer().getUsername())
                        .firstName(trainerDetails.getFirstName())
                        .lastName(trainerDetails.getLastName())
                        .phoneNumber(trainerDetails.getPhoneNumber())
                        .description(trainerDetails.getDescription())
                        .build())
                .collect(Collectors.toList());
    }
}
