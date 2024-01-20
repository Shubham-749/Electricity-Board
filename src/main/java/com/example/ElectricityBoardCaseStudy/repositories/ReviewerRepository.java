package com.example.ElectricityBoardCaseStudy.repositories;

import com.example.ElectricityBoardCaseStudy.model.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ReviewerRepository.java
@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {
    // Additional query methods can be added here if needed
}

