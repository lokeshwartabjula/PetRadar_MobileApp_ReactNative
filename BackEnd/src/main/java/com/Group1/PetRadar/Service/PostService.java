package com.Group1.PetRadar.Service;

import java.util.Map;
import java.util.UUID;

import com.Group1.PetRadar.DTO.post.AddPostDTO;
import com.Group1.PetRadar.Model.PostModel;

public interface PostService {

    Map<String, Object> savePost(AddPostDTO postmodel) throws Exception;

    PostModel getPostById(UUID id);

    PostModel updatePost(PostModel postmodel);

    String deletePostById(UUID id);
}
