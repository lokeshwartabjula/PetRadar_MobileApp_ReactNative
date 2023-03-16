package com.Group1.PetRadar.Repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.Group1.PetRadar.Model.Image;

public interface ImageRepository extends CrudRepository<Image, UUID> {
}