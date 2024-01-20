package com.example.ElectricityBoardCaseStudy.repositories;

import com.example.ElectricityBoardCaseStudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// UserRepository.java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be added here if needed

}

