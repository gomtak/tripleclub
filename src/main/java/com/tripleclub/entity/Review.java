package com.tripleclub.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class Review {
    @Id
    @Type(type="uuid-char")
    @Column(name = "review_id")
    private UUID reviewId;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @Type(type="uuid-char")
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @Type(type="uuid-char")
    @JoinColumn(name = "place_id")
    private Place place;

    @Column(name = "is_bonus")
    private boolean isBonus;

    @Builder
    public Review(UUID reviewId, String content, User user, Place place, boolean isBonus) {
        this.reviewId = reviewId;
        this.content = content;
        this.user = user;
        this.place = place;
        this.isBonus = isBonus;
    }

    public void setBonus(List<Review> review){
        if(review.size()==0) isBonus = true;
    }
}
