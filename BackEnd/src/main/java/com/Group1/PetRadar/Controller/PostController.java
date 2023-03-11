package com.Group1.PetRadar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.PetRadar.Model.PostModel;
import com.Group1.PetRadar.Service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/create")
    public PostModel createPost(@RequestBody PostModel postmodel) throws Exception {
        postService.savePost(postmodel);
        return postmodel;

    }

    @GetMapping("/get/{id}")
    public PostModel getPostById(@PathVariable("id") int id) {
        return postService.getPostById(id);
    }

    @PutMapping("/update")
    public String updatePost(@RequestBody PostModel postmodel) {
        return postService.updatePost(postmodel);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePostById(@PathVariable("id") int id) {
        return postService.deletePostById(id);
    }

}
