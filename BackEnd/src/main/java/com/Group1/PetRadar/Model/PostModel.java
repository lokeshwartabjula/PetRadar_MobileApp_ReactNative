package com.Group1.PetRadar.Model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;

@Entity()
@Transactional
@NoArgsConstructor
@Table(name = "post")
public class PostModel {

        @Id()
        @GeneratedValue(strategy = GenerationType.UUID)
        @JoinColumn(name = "id")
        UUID postId;

        String description;
        Date postDate;
        String location;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "userId")
        private User user;

        public void setPostId(UUID postId) {
                this.postId = postId;
        }

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

        public void setUser(User user) {
                this.user = user;
        }

}
