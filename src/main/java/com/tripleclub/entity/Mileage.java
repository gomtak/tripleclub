package com.tripleclub.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Mileage extends BaseEntity{
    @Id
    @Column(name = "mileage_id")
    @Type(type="uuid-char")
    private UUID mileageId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "review_id")
    private Review review;
    private int point;

    @Builder
    public Mileage(UUID mileageId, User user, Review review, int point) {
        this.mileageId = mileageId;
        this.user = user;
        this.review = review;
        this.point = point;
    }
}
