package com.example.ElectricityBoardCaseStudy.repositories;

import com.example.ElectricityBoardCaseStudy.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByDateOfApplicationBetween(Long startTimestamp, Long endTimestamp);
}

