package com.Group1.PetRadar.Controller;

import com.Group1.PetRadar.DTO.post.AddPostDTO;
import com.Group1.PetRadar.Model.PostModel;
import com.Group1.PetRadar.Service.PostService;
import com.Group1.PetRadar.protocol.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    // @PostMapping("/create")
    // public PostModel createPost(@RequestBody AddPostDTO postmodel) throws
    // Exception {
    // return postService.savePost(postmodel);
    // }
    @PostMapping("/create")
    public ResponseEntity<Response> createPost(
            @RequestParam() Map<String, String> paramList,
            @RequestParam("image") MultipartFile file) throws Exception {
        PostModel newPost = null;
        try {
            // PostModelBuilder dummy = PostModel.builder();
            AddPostDTO newPostDTO = new AddPostDTO();
            paramList.forEach((String key, String value) -> {
                switch (key) {
                    case "description" -> newPostDTO.setDescription(value);
                    case "postDate" -> newPostDTO.setPostDate(value);
                    case "location" -> newPostDTO.setLocation(value);
                    default -> throw new IllegalStateException("Unexpected value: " + key);
                }
            });

            // newPostDTO.setImage(file);
            // dummy1 = dummy.build();
            // System.out.println("================>" + dummy1.getDescription());

            newPost = postService.savePost(newPostDTO);
            // dummy2 = postService.savePost(dummy1);
        } catch (Exception e) {
            // TODO: handle exception
        }
        Response response = new Response();
        Map<String, Object> data = new HashMap<>();
        data.put("post", newPost);
        response.setData(data);
        response.setMessage(HttpStatus.ACCEPTED.name());
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getPostById(@PathVariable("id") UUID id) {
        PostModel post = null;
        Response failureResponse = null;

        try {
            post = postService.getPostById(id);
        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
        }
        Response response = new Response();
        Map<String, Object> data = new HashMap<>();
        data.put("post", post);
        response.setData(data);
        response.setMessage(HttpStatus.ACCEPTED.name());
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
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
