package com.Group1.PetRadar.DTO.post;

import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
public class UdpatePostDTO {

    private String description;
    private Date postDate;
    private String location;

    private String id;


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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UUID getId() {
        return UUID.fromString(id);
    }

    public void setId(String id) {
        this.id = id;
    }
}



