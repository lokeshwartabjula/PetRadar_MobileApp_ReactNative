package com.Group1.PetRadar.Repository;

import com.Group1.PetRadar.Model.PostModel;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostModel, UUID> {
}
