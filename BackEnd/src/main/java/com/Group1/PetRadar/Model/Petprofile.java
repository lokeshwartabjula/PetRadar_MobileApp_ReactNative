package com.Group1.PetRadar.Model;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.Date;

@Component
public class Petprofile
{
    int petId;
    String petName;
    String petBreed;
    Date petDob;
    String petCategory;
    int petQrImageId;
    String gender;
    String bio;
    float petHeightInCms;
    float weightInLbs;
    String petIdentificationMarks;
    String allergies;

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
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

    public int getPetQrImageId() {
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

    public float getPetHeightInCms() {
        return petHeightInCms;
    }

    public void setPetHeightInCms(float petHeightInCms) {
        this.petHeightInCms = petHeightInCms;
    }

    public float getWeightInLbs() {
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