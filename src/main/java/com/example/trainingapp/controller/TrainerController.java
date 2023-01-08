package com.example.trainingapp.controller;

import com.example.trainingapp.domain.dto.TrainerDetailsDto;
import com.example.trainingapp.domain.model.User;
import com.example.trainingapp.service.TrainerDetailsService;
import com.example.trainingapp.service.UserContextService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TrainerController {
    private final UserContextService userContextService;
    private final TrainerDetailsService trainerDetailsService;

    @GetMapping("/become-trainer")
    public String becomeTrainer(Model model) {
        model.addAttribute("trainerDetails", new TrainerDetailsDto());
        return "become-trainer-form";
    }

    @PostMapping("/process-trainer-form")
    public String processTrainerForm(@ModelAttribute TrainerDetailsDto trainerDetailsDto) {
        User loggedUser = userContextService.getLoggedUser();
        trainerDetailsService.addTrainer(trainerDetailsDto, loggedUser);
        return "home";
    }

    @GetMapping("/show-trainers")
    public String showTrainers(Model model) {
        model.addAttribute("trainers", trainerDetailsService.getTrainers());
        System.out.println("Trainers: " + trainerDetailsService.getTrainers());
        return "trainers-list";
    }
}