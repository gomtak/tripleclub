package com.tripleclub.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Place {
    @Id
    @Type(type="uuid-char")
    @Column(name = "place_id")
    private UUID placeId;
}
