package com.example.ElectricityBoardCaseStudy.controllers;


import com.example.ElectricityBoardCaseStudy.model.Application;
import com.example.ElectricityBoardCaseStudy.requestObjects.CreateApplicationRequest;
import com.example.ElectricityBoardCaseStudy.requestObjects.UpdateApplicationRequest;
import com.example.ElectricityBoardCaseStudy.services.ApplicationService;
import com.example.ElectricityBoardCaseStudy.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        Application application = applicationService.getApplicationById(id);
        return ResponseEntity.ok(application);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Application>> getAllApplication() {
        List<Application> application = applicationService.getAllApplications();
        return ResponseEntity.ok(application);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Application> createApplication(@RequestBody CreateApplicationRequest request) {
        Application createdApplication = applicationService.createApplication(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApplication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long id, @RequestBody UpdateApplicationRequest request) {
        Application updatedApplication = applicationService.updateApplication(id, request);
        return ResponseEntity.ok(updatedApplication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get_by_date_range/{startTimestamp}/{endTimestamp}")
    public ResponseEntity<List<Application>> filterByTimestampRange(
            @PathVariable long startTimestamp, @PathVariable long endTimestamp) {
        List<Application> result = applicationService.findByDateOfApplicationBetween(startTimestamp, endTimestamp);
        return ResponseEntity.ok(result);
    }

}
