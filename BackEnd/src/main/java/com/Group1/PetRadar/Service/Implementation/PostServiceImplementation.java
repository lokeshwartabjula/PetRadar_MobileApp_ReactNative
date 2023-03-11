package com.Group1.PetRadar.Service.Implementation;

import com.Group1.PetRadar.Model.PostModel;
import com.Group1.PetRadar.Repository.PetProfileRepository;
import com.Group1.PetRadar.Repository.PostRepository;
import com.Group1.PetRadar.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PostServiceImplementation implements PostService {


    @Autowired
    PostRepository postRepository;

    @Override
    public PostModel savePost(PostModel postmodel) {
        postmodel.setPostId(postmodel.getPostId());
        postRepository.save(postmodel);
        return postmodel;
    }

    @Override
    public PostModel getPostById(int id) {
        PostModel m = postRepository.findById(id).orElse(null);
        return m;
    }


    @Override
    public String updatePost(PostModel postmodel) {
        PostModel existingpost = postRepository.findById(postmodel.getPostId()).orElse(null);
        if(postmodel.getPostId()!=null)
            existingpost.setPostId(postmodel.getPostId());
        if(postmodel.getPostDate()!=null)
            existingpost.setPostDate(postmodel.getPostDate());
        if(postmodel.getDescription()!=null)
            existingpost.setDescription(postmodel.getDescription());
        if(postmodel.getLocation()!=null)
            existingpost.setLocation(postmodel.getLocation());


        postRepository.save(existingpost);
        return "Petprofile updated!";
    }

    @Override
    public String deletePostById(int id) {
        postRepository.deleteById(id);
        return "Petprofile deleted!";
    }



}
