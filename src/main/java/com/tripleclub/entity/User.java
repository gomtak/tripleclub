package com.tripleclub.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @Column(name = "user_id")
    private UUID userId;
    @OneToMany(mappedBy = "user")
    private List<Mileage> mileage = new ArrayList<>();
}
