package com.Group1.PetRadar.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.Group1.PetRadar.Model.UserModel;


public interface UserRepository extends CrudRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String username);

}
