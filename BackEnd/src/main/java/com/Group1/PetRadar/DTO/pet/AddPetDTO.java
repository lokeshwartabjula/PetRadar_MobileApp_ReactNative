package com.Group1.PetRadar.DTO.pet;

import java.util.Date;
import java.util.UUID;

public class AddPetDTO {

    private String petName;
    private String petBreed;
    private Date petDob;
    private String petCategory;
    private Integer petQrImageId;
    private String gender;
    private String bio;
    private Float petHeightInCms;
    private Float weightInLbs;
    private String petIdentificationMarks;
    private String allergies;
    private String userId;

    public AddPetDTO() {
    }

    public AddPetDTO(String petName, String petBreed, Date petDob, String petCategory, Integer petQrImageId,
            String gender, String bio, Float petHeightInCms, Float weightInLbs, String petIdentificationMarks,
            String allergies, String userId) {
        this.petName = petName;
        this.petBreed = petBreed;
        this.petDob = petDob;
        this.petCategory = petCategory;
        this.petQrImageId = petQrImageId;
        this.gender = gender;
        this.bio = bio;
        this.petHeightInCms = petHeightInCms;
        this.weightInLbs = weightInLbs;
        this.petIdentificationMarks = petIdentificationMarks;
        this.allergies = allergies;
        this.userId = userId;
    }

    // Getters and setters

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
        return this.petCategory;
    }

    public void setPetCategory(String petCategory) {
        this.petCategory = petCategory;
    }

    public Integer getPetQrImageId() {
        return this.petQrImageId;
    }

    public void setPetQrImageId(Integer petQrImageId) {
        this.petQrImageId = petQrImageId;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Float getPetHeightInCms() {
        return this.petHeightInCms;
    }

    public void setPetHeightInCms(Float petHeightInCms) {
        this.petHeightInCms = petHeightInCms;
    }

    public Float getWeightInLbs() {
        return this.weightInLbs;
    }

    public void setWeightInLbs(Float weightInLbs) {
        this.weightInLbs = weightInLbs;
    }

    public String getPetIdentificationMarks() {
        return this.petIdentificationMarks;
    }

    public void setPetIdentificationMarks(String petIdentificationMarks) {
        this.petIdentificationMarks = petIdentificationMarks;
    }

    public String getAllergies() {
        return this.allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public UUID getUserId() {
        return UUID.fromString(this.userId);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Other getters and setters
}
