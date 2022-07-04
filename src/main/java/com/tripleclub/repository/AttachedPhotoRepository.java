package com.tripleclub.repository;

import com.tripleclub.entity.AttachedPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttachedPhotoRepository extends JpaRepository<AttachedPhoto, UUID> {

    @Query("select a from AttachedPhoto a where a.review.reviewId = :reviewId")
    List<AttachedPhoto> findByReviewId(UUID reviewId);
}
