package com.Group1.PetRadar.DTO.post;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.Group1.PetRadar.Model.Location;

public class AddPostDTO extends Location {

    private String description;
    private Date postDate;
    private UUID userId;
    private MultipartFile image;

    // Default constructor
    public AddPostDTO() {
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        try {
            this.postDate = new Date(postDate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = UUID.fromString(userId);
    }

    public MultipartFile getImage() {
        return this.image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
