package com.Group1.PetRadar.Service;

import com.Group1.PetRadar.Model.Image;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Image saveImage(MultipartFile file, String type);

    Image save(Image image);
}
