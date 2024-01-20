package com.example.ElectricityBoardCaseStudy.services;

import com.example.ElectricityBoardCaseStudy.enums.ApplicationStatus;
import com.example.ElectricityBoardCaseStudy.model.Application;
import com.example.ElectricityBoardCaseStudy.model.Reviewer;
import com.example.ElectricityBoardCaseStudy.model.User;
import com.example.ElectricityBoardCaseStudy.repositories.ApplicationRepository;
import com.example.ElectricityBoardCaseStudy.requestObjects.CreateApplicationRequest;
import com.example.ElectricityBoardCaseStudy.requestObjects.UpdateApplicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ReviewerService reviewerService;

    @Autowired
    UserService userService;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    public Application createApplication(CreateApplicationRequest request) {
        long epochTimestampInMilliseconds = System.currentTimeMillis();
        Application application = new Application();
        User user = userService.getUserById(request.userId);
        application.setUser(user);
        application.setCategory(request.category);
        application.setLoad(request.load);
        application.setDateOfApplication(epochTimestampInMilliseconds);
        application.setStatus(ApplicationStatus.PENDING);
        return applicationRepository.save(application);
    }

    public Application updateApplication(Long id, UpdateApplicationRequest request) {
        long epochTimestampInMilliseconds = System.currentTimeMillis();
        Application application = getApplicationById(id);
        Reviewer reviewer = reviewerService.getReviewerById(request.reviewer_id);

        application.setReviewer(reviewer);
        application.setStatus(request.application_status);
        application.setReviewComment(request.application_review_comment);
        application.setModifiedDate(epochTimestampInMilliseconds);
        if (request.application_status == ApplicationStatus.APPROVED) {
            application.setDateOfApproval(epochTimestampInMilliseconds);
        }
        return applicationRepository.save(application);
    }

    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    public List<Application> findByDateOfApplicationBetween(Long startTimestamp, Long endTimestamp) {
        return applicationRepository.findByDateOfApplicationBetween(startTimestamp, endTimestamp);
    }
}
