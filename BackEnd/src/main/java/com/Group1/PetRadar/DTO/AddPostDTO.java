package com.Group1.PetRadar.DTO;

import java.util.Date;

public class AddPostDTO {

    private String description;
    private Date postDate;
    private String location;

    // Default constructor
    public AddPostDTO() {
    }

    // Parameterized constructor
    public AddPostDTO(String description, Date postDate, String location) {
        this.description = description;
        this.postDate = postDate;
        this.location = location;
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

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
