package com.Group1.PetRadar.Service.Implementation;

import com.Group1.PetRadar.DTO.AddPostDTO;
import com.Group1.PetRadar.Model.PostModel;
import com.Group1.PetRadar.Repository.PostRepository;
import com.Group1.PetRadar.Service.PostService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public PostModel savePost(AddPostDTO postmodel) {
        PostModel newPost = new PostModel();
        newPost.setDescription(postmodel.getDescription());
        newPost.setLocation(postmodel.getLocation());
        newPost.setPostDate(postmodel.getPostDate());
        return postRepository.save(newPost);
    }

    @Override
    public PostModel getPostById(UUID id) {
        PostModel m = postRepository.findById(id).orElse(null);
        return m;
    }

    @Override
    public PostModel updatePost(PostModel postmodel) {
        PostModel existingpost = postRepository.findById(postmodel.getPostId()).orElse(null);
        if (postmodel.getPostDate() != null)
            existingpost.setPostDate(postmodel.getPostDate());
        if (postmodel.getDescription() != null)
            existingpost.setDescription(postmodel.getDescription());
        if (postmodel.getLocation() != null)
            existingpost.setLocation(postmodel.getLocation());

        return postRepository.save(existingpost);
    }

    @Override
    public String deletePostById(UUID id) {
        postRepository.deleteById(id);
        return "Petprofile deleted!";
    }

}
