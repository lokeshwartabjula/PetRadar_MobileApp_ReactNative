package com.Group1.PetRadar.Service;

import java.util.UUID;

import com.Group1.PetRadar.DTO.post.AddPostDTO;
import com.Group1.PetRadar.DTO.post.UdpatePostDTO;
import com.Group1.PetRadar.Model.PostModel;

public interface PostService {

    PostModel savePost(AddPostDTO postmodel) throws Exception;

    PostModel getPostById(UUID id);

    PostModel updatePost(UdpatePostDTO postmodel, UUID id);

    String deletePostById(UUID id);
}
