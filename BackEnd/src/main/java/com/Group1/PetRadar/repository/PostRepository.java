package com.Group1.PetRadar.Repository;

import com.Group1.PetRadar.Model.PostModel;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostModel, UUID> {
    @Query(value = "SELECT * FROM post u WHERE (6371 * acos(cos(radians(?1)) * cos(radians(u.latitude)) * cos(radians(u.longitude) - radians(?2)) + sin(radians(?1)) * sin(radians(u.latitude)))) < 20", nativeQuery = true)
    Collection<PostModel> findPostByLocation(BigDecimal latitude, BigDecimal longitude);
}
