package com.Group1.PetRadar.Repository;

import com.Group1.PetRadar.Model.PostModel;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostModel, Integer> {
}
