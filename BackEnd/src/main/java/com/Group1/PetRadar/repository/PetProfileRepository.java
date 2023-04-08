package com.Group1.PetRadar.Repository;

import com.Group1.PetRadar.Model.PetprofileModel;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface PetProfileRepository extends CrudRepository<PetprofileModel, UUID> {
    Optional<PetprofileModel> findByUserUserId(UUID userId);
}
