package com.Group1.PetRadar.Service;

import java.util.UUID;

import com.Group1.PetRadar.DTO.AddPostDTO;
import com.Group1.PetRadar.Model.PostModel;

public interface PostService {

    PostModel savePost(AddPostDTO postmodel);

    PostModel getPostById(UUID id);

    PostModel updatePost(PostModel postmodel);

    String deletePostById(UUID id);
}
