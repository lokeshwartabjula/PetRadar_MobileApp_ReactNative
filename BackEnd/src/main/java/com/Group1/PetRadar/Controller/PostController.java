package com.Group1.PetRadar.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.PetRadar.DTO.AddPostDTO;
import com.Group1.PetRadar.Model.PostModel;
import com.Group1.PetRadar.Service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/create")
    public PostModel createPost(@RequestBody AddPostDTO postmodel) throws Exception {
        return postService.savePost(postmodel);
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
