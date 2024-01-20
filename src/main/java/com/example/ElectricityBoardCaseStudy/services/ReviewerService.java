package com.example.ElectricityBoardCaseStudy.services;

import com.example.ElectricityBoardCaseStudy.model.Reviewer;
import com.example.ElectricityBoardCaseStudy.repositories.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// ReviewerService.java
@Service
public class ReviewerService {

    @Autowired
    private ReviewerRepository reviewerRepository;

    public List<Reviewer> getAllReviewers() {
        return reviewerRepository.findAll();
    }

    public Reviewer getReviewerById(Long id) {
        return reviewerRepository.findById(id).orElse(null);
    }

    public Reviewer createReviewer(Reviewer reviewer) {
        return reviewerRepository.save(reviewer);
    }

    public Reviewer updateReviewer(Long id, Reviewer reviewer) {
        if (reviewerRepository.existsById(id)) {
//            reviewer.setId(id);
            return reviewerRepository.save(reviewer);
        }
        return null;
    }

    public void deleteReviewer(Long id) {
        reviewerRepository.deleteById(id);
    }
}

