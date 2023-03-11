package com.Group1.PetRadar.Model;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Entity()
public class PostModel {

        public Integer getPostId() {
                return postId;
        }

        public void setPostId(int postId) {
                this.postId = postId;
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

        @Id()
        @GeneratedValue(strategy= GenerationType.AUTO)
        Integer postId;
        String description;
        Date postDate;
        String location;

}


