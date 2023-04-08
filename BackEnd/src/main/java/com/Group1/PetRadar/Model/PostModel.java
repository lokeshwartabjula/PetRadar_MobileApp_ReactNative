package com.Group1.PetRadar.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
        String ImageUrl;
        String userName;
        String userProfilePicture;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "userId")
        private User user;

        @Column(precision = 10, scale = 6)
        private BigDecimal latitude;

        @Column(precision = 10, scale = 6)
        private BigDecimal longitude;

        public BigDecimal getLatitude() {
                return this.latitude;
        }

        public void setLatitude(BigDecimal latitude) {
                this.latitude = latitude;
        }

        public BigDecimal getLongitude() {
                return this.longitude;
        }

        public void setLongitude(BigDecimal longitude) {
                this.longitude = longitude;
        }

        public void setPostId(UUID postId) {
                this.postId = postId;
        }

        public String getImageUrl() {
                return ImageUrl;
        }

        public void setImageUrl(String imagexUrl) {
                ImageUrl = imagexUrl;
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

        public void setUser(User user) {
                this.user = user;
        }

        public User getUser() {
                return user;
        }

        public String getUserName() {
                return this.userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getUserProfilePicture() {
                return this.userProfilePicture;
        }

        public void setUserProfilePicture(String userProfilePicture) {
                this.userProfilePicture = userProfilePicture;
        }
}