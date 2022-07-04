package com.tripleclub.repository;

import com.tripleclub.entity.Mileage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MileageRepository extends JpaRepository<Mileage, UUID> {
    @Query("select m.mileageId from Mileage m where m.review.reviewId = :reviewId")
    Optional<Mileage> findByReviewId(UUID reviewId);

    @Modifying
    @Query("delete from Mileage m where m.review.reviewId = :reviewId")
    void deleteAllByReviewId(UUID reviewId);

    @Query("select m from Mileage m where m.user.userId = :userId")
    List<Mileage> findByUserId(UUID userId);
}
