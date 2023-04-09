package com.Group1.PetRadar.Model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;

@Transactional
@NoArgsConstructor
@Table(name = "pet_profile")
@Entity()
public class PetprofileModel {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    @JoinColumn(name = "id")
    UUID petId;
    String petName;
    String petBreed;
    int age;
    String petCategory;
    String gender;
    String bio;
    Float petHeightInCms;
    Float weightInLbs;
    String petIdentificationMarks;
    String allergies;
    String ImageUrl;

    @Lob
    @Column(name = "image_bytes", columnDefinition = "BLOB")
    byte[] petQrImage;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalHistory> medicalHistories;

    // Getters and setters
    public UUID getPetId() {
        return petId;
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
        return petCategory;
    }

    public void setPetCategory(String petCategory) {
        this.petCategory = petCategory;
    }

    public byte[] getPetQrImage() {
        return petQrImage;
    }

    public byte[] setPetQrImage(byte[] petQrImage) {
        return this.petQrImage = petQrImage;
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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MedicalHistory> getMedicalHistories() {
        return medicalHistories;
    }

    public String getImageUrl() {
        return this.ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }
}