package com.Group1.PetRadar.Service.Implementation;

import com.Group1.PetRadar.Model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group1.PetRadar.Repository.ImageRepository;
import com.Group1.PetRadar.Service.ImageService;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.Group1.PetRadar.utils.FileUpload.saveFile;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    public Image saveImage(MultipartFile file, String type) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "Image/"+type+"/";
        Image image = new Image();
        try {
            String uploadPath = saveFile(uploadDir, fileName, file);
            image.setPath(uploadPath);
            image.setName(fileName);
            return imageRepository.save(image);
        } catch (IOException e) {
            e.printStackTrace();
            return image;
        }
    }
}
