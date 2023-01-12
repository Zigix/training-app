package com.example.trainingapp.repository;

import com.example.trainingapp.domain.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {
}
