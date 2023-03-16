package com.Group1.PetRadar.Model;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID ImageId;

    private String name;
    private String path;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

    @CreationTimestamp()
    private LocalDateTime createdAt;

    @CreationTimestamp()
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "image")
    private User user;

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

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
