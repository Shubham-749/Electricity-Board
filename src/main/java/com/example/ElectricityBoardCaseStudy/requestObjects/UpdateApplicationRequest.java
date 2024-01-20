package com.example.ElectricityBoardCaseStudy.requestObjects;

import com.example.ElectricityBoardCaseStudy.enums.ApplicationReviewComment;
import com.example.ElectricityBoardCaseStudy.enums.ApplicationStatus;

public class UpdateApplicationRequest {
    public long reviewer_id;
    public ApplicationStatus application_status;
    public ApplicationReviewComment application_review_comment;
}