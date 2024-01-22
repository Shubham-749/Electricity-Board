package com.example.ElectricityBoardCaseStudy.services;

import com.example.ElectricityBoardCaseStudy.enums.ApplicationStatus;
import com.example.ElectricityBoardCaseStudy.model.Application;
import com.example.ElectricityBoardCaseStudy.model.Reviewer;
import com.example.ElectricityBoardCaseStudy.model.User;
import com.example.ElectricityBoardCaseStudy.repositories.ApplicationRepository;
import com.example.ElectricityBoardCaseStudy.requestObjects.CreateApplicationRequest;
import com.example.ElectricityBoardCaseStudy.requestObjects.UpdateApplicationRequest;
import org.apache.coyote.BadRequestException;
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

    public Application createApplication(CreateApplicationRequest request) throws Exception {

        if (request.load > 200) {
            throw new BadRequestException("Cannot apply for more than 200KV");
        }
        Application application = new Application();
        User user = userService.getUserById(request.userId);
        if (user == null) {
            throw new BadRequestException("User does not exist");
        }
        long epochTimestampInMilliseconds = System.currentTimeMillis();
        application.setUser(user);
        application.setCategory(request.category);
        application.setLoadVal(request.load);
        application.setDateOfApplication(epochTimestampInMilliseconds);
        application.setStatus(ApplicationStatus.PENDING);
        return applicationRepository.save(application);
    }

    public Application updateApplication(Long id, UpdateApplicationRequest request) throws Exception {
        if (request.application_status == null && request.application_review_comment == null) {
            throw new BadRequestException("Bad request");
        }
        Application application = getApplicationById(id);
        Reviewer reviewer = reviewerService.getReviewerById(request.reviewer_id);

        if (application == null) {
            throw new BadRequestException("application cannot be null");
        }
        if (reviewer == null) {
            throw new BadRequestException("reviewer cannot be null");
        }

        long epochTimestampInMilliseconds = System.currentTimeMillis();

        if (request.application_status != null) {
            application.setStatus(request.application_status);
        }
        if (request.application_review_comment != null) {
            application.setReviewComment(request.application_review_comment);
        }
        application.setModifiedDate(epochTimestampInMilliseconds);
        application.setReviewer(reviewer);
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

