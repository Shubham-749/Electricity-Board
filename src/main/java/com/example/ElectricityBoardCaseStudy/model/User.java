package com.example.ElectricityBoardCaseStudy.model;

import com.example.ElectricityBoardCaseStudy.enums.Gender;
import com.example.ElectricityBoardCaseStudy.enums.Government_id_type;
import com.example.ElectricityBoardCaseStudy.enums.Ownership;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "pin_code")
    private int pinCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "ownership")
    private Ownership ownership;

    @Enumerated(EnumType.STRING)
    @Column(name = "government_id_type")
    private Government_id_type government_id_type;

    @Column(name = "government_id_number")
    private int government_id_number;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public void setOwnership(Ownership ownership) {
        this.ownership = ownership;
    }

    public void setGovernment_id_type(Government_id_type government_id_type) {
        this.government_id_type = government_id_type;
    }

    public void setGovernment_id_number(int government_id_number) {
        this.government_id_number = government_id_number;
    }

}



