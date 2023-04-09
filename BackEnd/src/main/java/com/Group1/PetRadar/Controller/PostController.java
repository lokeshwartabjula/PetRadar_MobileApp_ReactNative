package com.Group1.PetRadar.Controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Group1.PetRadar.DTO.post.AddPostDTO;
import com.Group1.PetRadar.Model.PostModel;
import com.Group1.PetRadar.Service.PostService;
import com.Group1.PetRadar.protocol.Response;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Response> createPost(
            @RequestParam() Map<String, String> paramList,
            @RequestParam(name = "image", required = true) MultipartFile file) throws Exception {
        Map<String, Object> newPost = new HashMap<>();
        Response failureResponse = null;
        try {
            AddPostDTO newPostDTO = new AddPostDTO();
            paramList.forEach((String key, String value) -> {
                switch (key) {
                    case "description" -> newPostDTO.setDescription(value);
                    case "postDate" -> newPostDTO.setPostDate(value);
                    case "userId" -> newPostDTO.setUserId(value);
                    case "latitude" -> newPostDTO.setLatitude(new BigDecimal(value));
                    case "longitude" -> newPostDTO.setLongitude(new BigDecimal(value));
                    case "userName" -> newPostDTO.setUserName(value);
                    case "userProfilePicture" -> newPostDTO.setUserProfilePicture(value);
                    default -> throw new IllegalStateException("Unexpected value: " + key);
                }
            });
            newPostDTO.setImage(file);

            newPost = postService.savePost(newPostDTO);
        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
        }
        Response response = new Response();
        response.setData(newPost);
        response.setMessage(HttpStatus.ACCEPTED.name());
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping("/get/{id}")
    public PostModel getPostById(@PathVariable("id") UUID id) {
        return postService.getPostById(id);
    }

    @PutMapping("/update")
    public PostModel updatePost(@RequestBody PostModel postmodel) {
        return postService.updatePost(postmodel);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePostById(@PathVariable("id") UUID id) {
        return postService.deletePostById(id);
    }

}
