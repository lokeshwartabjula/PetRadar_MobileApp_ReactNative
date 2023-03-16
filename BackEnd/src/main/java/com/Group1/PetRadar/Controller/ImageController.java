package com.Group1.PetRadar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.Group1.PetRadar.Service.ImageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.Group1.PetRadar.utils.FileUpload.saveFile;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;
    @PostMapping("/save")
    public String saveimage(@RequestParam("image") MultipartFile file, @RequestParam("type") String type) {
        try {
            imageService.saveImage(file, type);
            return "save image succesfully";
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "Bad Request";
        }
    }


}
