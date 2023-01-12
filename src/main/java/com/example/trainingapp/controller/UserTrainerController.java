package com.example.trainingapp.controller;

import com.example.trainingapp.domain.dto.DietDto;
import com.example.trainingapp.domain.dto.TrainingDto;
import com.example.trainingapp.domain.dto.UserTrainerDto;
import com.example.trainingapp.domain.mapper.EntityDtoMapper;
import com.example.trainingapp.domain.model.User;
import com.example.trainingapp.domain.model.UserTrainer;
import com.example.trainingapp.repository.UserTrainerRepository;
import com.example.trainingapp.service.UserContextService;
import com.example.trainingapp.service.UserTrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class UserTrainerController {
    private final UserContextService userContextService;
    private final UserTrainerRepository userTrainerRepository;
    private final UserTrainerService userTrainerService;
    private final EntityDtoMapper mapper;

    @GetMapping("/user-trainer") // TODO: zobacz wszystkie polaczenia usera z trenerami
    public String showAllUserTrainerConnections(Model model) {
        User loggedUser = userContextService.getLoggedUser();
        List<UserTrainer> userTrainerList = new ArrayList<>();
        if (loggedUser.isTrainer()) {
            userTrainerList = userTrainerRepository.findAllByTrainer(loggedUser);
        } else {
            userTrainerList = userTrainerRepository.findAllByUser(loggedUser);
        }
        List<UserTrainerDto> userTrainerDtoList = userTrainerList.stream().map(mapper::toUserTrainerDto).collect(Collectors.toList());
        model.addAttribute("userTrainerList", userTrainerDtoList);
        model.addAttribute("loggedUser", loggedUser);
        return ""; // TODO: <-- widok
    }

    @GetMapping("/user-trainer/{userTrainerId}")
    public String showOneUserTrainerConnection(@PathVariable Long userTrainerId, Model model) {
        UserTrainer userTrainer = userTrainerRepository.getById(userTrainerId);
        User loggedUser = userContextService.getLoggedUser();
        model.addAttribute("userTrainer", mapper.toUserTrainerDto(userTrainer));
        model.addAttribute("loggedUser", loggedUser);
        return "";
    }

    @GetMapping("/user-trainer/{userTrainerId}/diet")
    public String addDietForm(@PathVariable Long userTrainerId, Model model) {
        DietDto dietDto = new DietDto();
        dietDto.setUserTrainerId(userTrainerId);
        model.addAttribute("diet", dietDto);
        return ""; // TODO: <-- widok dla dodawania diety
    }

    @PostMapping("/user-trainer/{userTrainerId}/diet")
    public String processDietForm(@PathVariable Long userTrainerId, @ModelAttribute DietDto dietDto) {
        userTrainerService.addDiet(dietDto);
        return ""; // TODO: <-- redirect na user training view
    }

    @GetMapping("/user-trainer/{userTrainerId}/training")
    public String addTrainingForm(@PathVariable Long userTrainerId, Model model) {
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setUserTrainerId(userTrainerId);
        model.addAttribute("training", trainingDto);
        return ""; // TODO: <-- widok dla dodawania treningu
    }

    @PostMapping("/user-trainer/{userTrainerId}/training")
    public String processTrainingForm(@PathVariable Long userTrainerId, @ModelAttribute TrainingDto trainingDto) {
        userTrainerService.addTraining(trainingDto);
        return ""; // TODO: <-- redirect na user training view
    }
}
