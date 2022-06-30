package com.tripleclub.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    private UUID userId;
    @OneToMany
    @JoinColumn(name = "mileage_id")
    private List<Mileage> mileage;
}
