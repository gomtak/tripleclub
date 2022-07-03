package com.tripleclub.repository;

import com.tripleclub.entity.AttachedPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttachedPhotoRepository extends JpaRepository<AttachedPhoto, UUID> {
}
