package com.tripleclub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Review {
    @Id
    private UUID reviewId;
    private String content;
    @OneToMany
    @JoinColumn(name = "attachedPhotoId")
    private List<AttachedPhoto> attachedPhoto;
    private UUID userId;
    private UUID placeId;

    public Review(UUID reviewId, String content, List<AttachedPhoto> attachedPhoto, UUID userId, UUID placeId) {
        this.reviewId = reviewId;
        this.content = content;
        this.attachedPhoto = attachedPhoto;
        this.userId = userId;
        this.placeId = placeId;
    }
}
