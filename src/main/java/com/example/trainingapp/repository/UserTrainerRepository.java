package com.example.trainingapp.repository;

import com.example.trainingapp.domain.model.User;
import com.example.trainingapp.domain.model.UserTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTrainerRepository extends JpaRepository<UserTrainer, Long> {
    List<UserTrainer> findAllByUser(User user);

    List<UserTrainer> findAllByTrainer(User user);

    UserTrainer findByUserIdAndTrainerId(Long userId, Long trainerId);
}
