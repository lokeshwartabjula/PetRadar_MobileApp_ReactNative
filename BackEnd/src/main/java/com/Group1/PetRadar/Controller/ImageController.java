package com.Group1.PetRadar.Controller;

import com.Group1.PetRadar.protocol.Response;
import com.Group1.PetRadar.utils.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Group1.PetRadar.Service.ImageService;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImageController {

    @Autowired
    AwsService awsService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveimage(@RequestParam("image") MultipartFile file, @RequestParam("type") String type) {
            Response failureResponse = null;
            Response response = new Response();;
            try {
                awsService.save(file);
                response.setData("Image Saved Successfully");
            }
            catch (Exception e) {
                failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                        HttpStatus.UNAUTHORIZED.name());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
            }
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }


    @GetMapping
    public ResponseEntity<Object> findByName(@RequestParam(required = false) Map<String, String> params) {
        System.out.println(params);
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.noCache())
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + params.get("filename") + "\"")
                .body(new InputStreamResource(awsService.findByName(params.get("filename"))));
    }
}
