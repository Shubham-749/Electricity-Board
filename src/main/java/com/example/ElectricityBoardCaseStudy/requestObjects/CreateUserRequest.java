package com.example.ElectricityBoardCaseStudy.requestObjects;

import com.example.ElectricityBoardCaseStudy.enums.Gender;
import com.example.ElectricityBoardCaseStudy.enums.Government_id_type;
import com.example.ElectricityBoardCaseStudy.enums.Ownership;

public class CreateUserRequest {

    public String name;

    public Gender gender;

    public String district;

    public String state;

    public int pinCode;

    public Ownership ownership;

    public Government_id_type government_id_type;

    public int government_id_number;
}
