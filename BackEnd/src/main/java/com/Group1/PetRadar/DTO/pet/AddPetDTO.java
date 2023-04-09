package com.Group1.PetRadar.DTO.pet;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class AddPetDTO {

    private UUID petId;
    private String petName;
    private String petBreed;
    private int age;
    private String petCategory;
    private String gender;
    private String bio;
    private Float petHeightInCms;
    private Float weightInLbs;
    private String petIdentificationMarks;
    private String allergies;
    private String userId;
    private MultipartFile image;

    // No argument constructor
    public AddPetDTO() {
    }

    // Getters and setters
    public UUID getPetId() {
        return this.petId;
    }

    public void setPetId(String petId) {
        this.petId = UUID.fromString(petId);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPetCategory() {
        return this.petCategory;
    }

    public void setPetCategory(String petCategory) {
        this.petCategory = petCategory;
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

    public MultipartFile getImage() {
        return this.image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
