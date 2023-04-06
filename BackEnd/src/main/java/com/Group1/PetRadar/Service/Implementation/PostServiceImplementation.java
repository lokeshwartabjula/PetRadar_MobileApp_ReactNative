package com.Group1.PetRadar.Service.Implementation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group1.PetRadar.DTO.post.AddPostDTO;
import com.Group1.PetRadar.DTO.post.UdpatePostDTO;
import com.Group1.PetRadar.Model.PostModel;
import com.Group1.PetRadar.Model.User;
import com.Group1.PetRadar.Repository.PostRepository;
import com.Group1.PetRadar.Service.PostService;
import com.Group1.PetRadar.Service.UserService;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Override
    public PostModel savePost(AddPostDTO postmodel) throws Exception {
        PostModel newPost = new PostModel();
        User user = null;
        try {
            String userId = postmodel.getUserId().toString();
            user = userService.findById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Please enter valid user ID");
        }

        newPost.setDescription(postmodel.getDescription());
        newPost.setPostDate(postmodel.getPostDate());
        newPost.setLatitude(postmodel.getLatitude());
        newPost.setLongitude(postmodel.getLongitude());
        newPost.setUser(user);
        return postRepository.save(newPost);
    }

    @Override
    public PostModel getPostById(UUID id) {
        PostModel m = postRepository.findById(id).orElse(null);
        return m;
    }

    @Override
    public PostModel updatePost(UdpatePostDTO postmodel, UUID id) {
        PostModel existingpost = postRepository.findById(id).orElse(null);
        if (postmodel.getPostDate() != null)
            existingpost.setPostDate(postmodel.getPostDate());
        if (postmodel.getDescription() != null)
            existingpost.setDescription(postmodel.getDescription());

        return postRepository.save(existingpost);
    }

    @Override
    public String deletePostById(UUID id) {
        postRepository.deleteById(id);
        return "post deleted!";
    }

}
