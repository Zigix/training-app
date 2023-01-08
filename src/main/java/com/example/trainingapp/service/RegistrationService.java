package com.example.trainingapp.service;

import com.example.trainingapp.domain.dto.UserDto;
import com.example.trainingapp.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    public void register(UserDto userDto) {
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(encoder.encode(userDto.getPassword()));

        userService.save(user);
    }
}
