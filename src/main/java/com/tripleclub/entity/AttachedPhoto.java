package com.tripleclub.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class AttachedPhoto {
    @Id
    private UUID attachedPhotoId;
}
