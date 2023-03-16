package com.Group1.PetRadar.Model;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Image {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID ImageId;

    private String name;
    private String path;

    @CreationTimestamp()
    private LocalDateTime createdAt;

    @CreationTimestamp()
    private LocalDateTime updatedAt;

    public UUID getImageId() {
        return this.ImageId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
