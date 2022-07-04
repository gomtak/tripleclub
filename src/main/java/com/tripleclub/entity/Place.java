package com.tripleclub.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Place {
    @Id
    @Type(type="uuid-char")
    @Column(name = "place_id")
    private UUID placeId;

    @Column(name = "place_name")
    private String placeName;

    @OneToMany(mappedBy = "place")
    private List<Review> review;
}
