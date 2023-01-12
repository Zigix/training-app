package com.example.trainingapp.controller;

import com.example.trainingapp.domain.dto.TrainerDetailsDto;
import com.example.trainingapp.domain.dto.TrainerDto;
import com.example.trainingapp.domain.model.User;
import com.example.trainingapp.domain.model.UserTrainer;
import com.example.trainingapp.service.TrainerDetailsService;
import com.example.trainingapp.service.UserContextService;
import com.example.trainingapp.service.UserTrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class TrainerController {
    private final UserContextService userContextService;
    private final TrainerDetailsService trainerDetailsService;
    private final UserTrainerService userTrainerService;

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
        User loggedUser = userContextService.getLoggedUser();
        List<TrainerDto> trainers = trainerDetailsService.getTrainers()
                .stream()
                .filter(t -> !Objects.equals(t.getTrainerId(), loggedUser.getId()))
                .collect(Collectors.toList());
        model.addAttribute("trainers", trainers);
        System.out.println("Trainers: " + trainerDetailsService.getTrainers());
        return "trainers-list";
    }

    @GetMapping("/request-trainer/{trainerId}")
    public String requestTrainer(@PathVariable Long trainerId, Model model) {
        User loggedUser = userContextService.getLoggedUser();
        UserTrainer userTrainer = userTrainerService.connectUserWithTrainer(trainerId, loggedUser);
        model.addAttribute("userTrainer", userTrainer);
        return "redirect:/"; //TODO: <-- jakiś widok po polaczeniu usera z trenerem
    }
}
