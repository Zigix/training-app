package com.example.trainingapp.controller;

import com.example.trainingapp.domain.dto.UserDto;
import com.example.trainingapp.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign-up")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "registration";
    }

    @PostMapping
    public String processSignUpForm(
            @ModelAttribute("user") @Valid UserDto userDto,
            Errors errors) {

        if (errors.hasErrors()) {
            return "registration";
        }

        registrationService.register(userDto);

        return "registration-successful";
    }
}
