package com.tripleclub.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class AttachedPhoto {
    @Id
    @Column(name = "attached_photo_id")
    @Type(type="uuid-char")
    private UUID attachedPhotoId;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @Builder
    public AttachedPhoto(UUID attachedPhotoId, Review review) {
        this.attachedPhotoId = attachedPhotoId;
        this.review = review;
    }
}
