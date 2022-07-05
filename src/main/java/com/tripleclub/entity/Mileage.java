package com.tripleclub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    @JsonManagedReference
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
