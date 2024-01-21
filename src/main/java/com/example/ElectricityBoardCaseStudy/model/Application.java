package com.example.ElectricityBoardCaseStudy.model;

import com.example.ElectricityBoardCaseStudy.enums.ApplicationCategory;
import com.example.ElectricityBoardCaseStudy.enums.ApplicationReviewComment;
import com.example.ElectricityBoardCaseStudy.enums.ApplicationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "application")
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ApplicationCategory category;

    @Column(name = "load_val")
    private int loadVal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_application")
    private Long dateOfApplication;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_approval")
    private Long dateOfApproval;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Long modifiedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status") // Default value for createdAt property
    private ApplicationStatus status;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;

    @Enumerated(EnumType.STRING)
    @Column(name = "Reviewer_comment")
    private ApplicationReviewComment reviewComment;
}
