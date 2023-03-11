package com.Group1.PetRadar.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Group1.PetRadar.Model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String username);

}
