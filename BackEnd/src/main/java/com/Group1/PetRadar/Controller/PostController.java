package com.Group1.PetRadar.Controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Group1.PetRadar.DTO.post.AddPostDTO;
import com.Group1.PetRadar.DTO.post.UdpatePostDTO;
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
            @RequestParam("image") MultipartFile file) throws Exception {
        PostModel newPost = null;
        Response failureResponse = null;

        try {
            // PostModelBuilder dummy = PostModel.builder();
            AddPostDTO newPostDTO = new AddPostDTO();
            paramList.forEach((String key, String value) -> {
                switch (key) {
                    case "description" -> newPostDTO.setDescription(value);
                    case "postDate" -> newPostDTO.setPostDate(value);
                    case "location" -> newPostDTO.setLocation(value);
                    case "userId" -> newPostDTO.setUserId(value);
                    default -> throw new IllegalStateException("Unexpected value: " + key);
                }
            });

            // newPostDTO.setImage(file);
            // dummy1 = dummy.build();
            // System.out.println("================>" + dummy1.getDescription());

            newPost = postService.savePost(newPostDTO);
            // dummy2 = postService.savePost(dummy1);
        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
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
    public ResponseEntity<Response> updatePost(
            @RequestParam() Map<String, String> paramList) throws Exception {
        Response failureResponse = null;
        PostModel updatePost = null;

        try {
            UdpatePostDTO updatePostDTO = new UdpatePostDTO();
            paramList.forEach((String key, String value) -> {
                switch (key) {
                    case "description":
                        updatePostDTO.setDescription(value);
                        break;
                    case "postDate":
                        updatePostDTO.setPostDate(value);
                        break;
                    case "location":
                        updatePostDTO.setLocation(value);
                        break;
                    case "postId":
                        updatePostDTO.setId(value);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + key);
                }
            });

            updatePost = postService.updatePost(updatePostDTO, updatePostDTO.getId());

        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
        }

        Response response = new Response();
        Map<String, Object> data = new HashMap<>();
        data.put("post", updatePost);
        response.setData(data);
        response.setMessage(HttpStatus.ACCEPTED.name());
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePostById(@PathVariable("id") UUID id) {
        Response failureResponse = null;

        try {
            postService.deletePostById(id);
            Response response = new Response();
            Map<String, Object> data = new HashMap<>();
            data.put("message", "Post deleted succesfully");
            response.setData(data);
            response.setMessage(HttpStatus.ACCEPTED.name());
            response.setStatus(HttpStatus.ACCEPTED.value());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
        }
    }

}
