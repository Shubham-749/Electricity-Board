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

    public Long getDateOfApplication() {
        return dateOfApplication;
    }

    public Long getDateOfApproval() {
        return dateOfApproval;
    }

    public Long getModifiedDate() {
        return modifiedDate;
    }

    public void setDateOfApplication(Long dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public void setDateOfApproval(Long dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    public void setModifiedDate(Long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLoad(int load) {
        this.loadVal = load;
    }

    public void setCategory(ApplicationCategory category) {
        this.category = category;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public void setReviewComment(ApplicationReviewComment reviewComment) {
        this.reviewComment = reviewComment;
    }

}
