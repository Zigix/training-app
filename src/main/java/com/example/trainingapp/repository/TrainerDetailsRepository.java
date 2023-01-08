package com.example.trainingapp.repository;

import com.example.trainingapp.domain.model.TrainerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerDetailsRepository extends JpaRepository<TrainerDetails, Long> {
}
