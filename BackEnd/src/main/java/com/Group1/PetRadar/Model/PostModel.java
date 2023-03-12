package com.Group1.PetRadar.Model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity()
public class PostModel {

        @Id()
        @GeneratedValue(strategy = GenerationType.UUID)
        @JoinColumn(name = "id")
        UUID postId;

        String description;
        Date postDate;
        String location;

        public UUID getPostId() {
                return postId;
        }

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
