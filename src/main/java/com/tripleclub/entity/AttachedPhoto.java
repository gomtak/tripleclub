package com.tripleclub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class AttachedPhoto {
    @Id
    @Column(name = "attached_photo_id")
    private UUID attachedPhotoId;
}
