package com.Group1.PetRadar.Service;

import com.Group1.PetRadar.Model.PostModel;
import org.springframework.stereotype.Service;

public interface PostService {

    PostModel savePost(PostModel postmodel);
    PostModel getPostById(int id);
    String updatePost(PostModel postmodel);
    String deletePostById(int id);
}
