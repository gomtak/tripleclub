package com.tripleclub.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Place {
    @Id
    private UUID placeId;
}
