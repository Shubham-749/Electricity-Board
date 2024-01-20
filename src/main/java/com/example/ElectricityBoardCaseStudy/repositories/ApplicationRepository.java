package com.example.ElectricityBoardCaseStudy.repositories;

import com.example.ElectricityBoardCaseStudy.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

// ApplicationRepository.java
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // Additional query methods can be added here if needed

    List<Application> findByDateOfApplicationBetween(Long startTimestamp, Long endTimestamp);

}

