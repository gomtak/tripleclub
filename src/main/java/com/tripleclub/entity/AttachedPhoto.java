package com.tripleclub.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class AttachedPhoto {
    @Id
    @Column(name = "attached_photo_id")
    @Type(type="uuid-char")
    private UUID attachedPhotoId;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;
}
