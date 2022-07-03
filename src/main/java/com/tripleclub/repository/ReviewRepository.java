package com.tripleclub.repository;

import com.tripleclub.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    @Query("select r from Review r where r.place = :placeId")
    Review findByPlaceId(UUID placeId);
}
