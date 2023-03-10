package com.Group1.PetRadar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.Date;


@Entity
@Table(name = "pet_profile_duplicate")
public class PetprofileModel
{


    @Id
    public Integer petId;
    String petName;
    String petBreed;
    Date petDob;
    String petCategory;
    Integer petQrImageId;
    String gender;
    String bio;
    Float petHeightInCms;
    Float weightInLbs;
    String petIdentificationMarks;
    String allergies;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public Date getPetDob() {
        return petDob;
    }

    public void setPetDob(Date petDob) {
        this.petDob = petDob;
    }

    public String getPetCategory() {
        return petCategory;
    }

    public void setPetCategory(String petCategory) {
        this.petCategory = petCategory;
    }

    public Integer getPetQrImageId() {
        return petQrImageId;
    }

    public void setPetQrImageId(int petQrImageId) {
        this.petQrImageId = petQrImageId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Float getPetHeightInCms() {
        return petHeightInCms;
    }

    public void setPetHeightInCms(float petHeightInCms) {
        this.petHeightInCms = petHeightInCms;
    }

    public Float getWeightInLbs() {
        return weightInLbs;
    }

    public void setWeightInLbs(float weightInLbs) {
        this.weightInLbs = weightInLbs;
    }

    public String getPetIdentificationMarks() {
        return petIdentificationMarks;
    }

    public void setPetIdentificationMarks(String petIdentificationMarks) {
        this.petIdentificationMarks = petIdentificationMarks;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }



}