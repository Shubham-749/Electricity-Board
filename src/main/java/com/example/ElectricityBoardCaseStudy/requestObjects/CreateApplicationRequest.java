package com.example.ElectricityBoardCaseStudy.requestObjects;

import com.example.ElectricityBoardCaseStudy.enums.ApplicationCategory;

public class CreateApplicationRequest {
    public long userId;
    public ApplicationCategory category;
    public int load;
}
