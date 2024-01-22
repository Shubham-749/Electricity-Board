package com.example.ElectricityBoardCaseStudy.controllers;

import com.example.ElectricityBoardCaseStudy.model.Reviewer;
import com.example.ElectricityBoardCaseStudy.services.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviewer")
public class ReviewerController {

    @Autowired
    private ReviewerService reviewerService;

    @GetMapping("/all")
    public ResponseEntity<List <Reviewer>> getAllReviewers() {
        List <Reviewer> reviewer = reviewerService.getAllReviewers();
        return ResponseEntity.ok(reviewer);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reviewer> getReviewerById(@PathVariable Long id) {
        Reviewer reviewer = reviewerService.getReviewerById(id);
        return ResponseEntity.ok(reviewer);
    }

    @PostMapping("/create")
    public ResponseEntity<Reviewer> createReviewer(@RequestBody Reviewer reviewer) {
        Reviewer createdReviewer = reviewerService.createReviewer(reviewer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReviewer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reviewer> updateReviewer(@PathVariable Long id, @RequestBody Reviewer reviewer) {
        Reviewer updatedReviewer = reviewerService.updateReviewer(id, reviewer);
        return ResponseEntity.ok(updatedReviewer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewer(@PathVariable Long id) {
        reviewerService.deleteReviewer(id);
        return ResponseEntity.noContent().build();
    }
}

