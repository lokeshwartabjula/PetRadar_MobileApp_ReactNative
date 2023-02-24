package com.Group1.PetRadar.Model;
import java.util.Date;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

@Component;
public class Post {

        public int getPostId() {
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

        int postId;
        String description;
        Date postDate;
        String location;

}


