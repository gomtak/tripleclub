package com.tripleclub.repository;

import com.tripleclub.entity.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MileageRepository extends JpaRepository<Mileage, UUID> {
    @Query("select m.mileageId from Mileage m where m.review.reviewId = :reviewId")
    Optional<Mileage> findByReviewId(UUID reviewId);
}
