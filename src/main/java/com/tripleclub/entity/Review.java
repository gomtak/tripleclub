package com.tripleclub.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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
    @JoinColumn(name = "attached_photo_ids")
    private List<AttachedPhoto> attachedPhotoIds = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @Column(name = "is_first")
    private boolean isFirst;

    @Builder
    public Review(UUID reviewId, String content, List<AttachedPhoto> attachedPhotoIds, User user, Place place, boolean isFirst) {
        this.reviewId = reviewId;
        this.content = content;
        this.attachedPhotoIds = attachedPhotoIds;
        this.user = user;
        this.place = place;
        this.isFirst = isFirst;
    }
    public int countPoint() {
        int count = 0;
        if(this.content.length()>0) count ++;
        if(this.attachedPhotoIds.size()>0) count ++;
        return count;
    }
}
