package com.Group1.PetRadar.Model;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;
import java.util.*;

public class ImageModel {

    int imageId;
    String imageLink;

    String imageType;
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }


}