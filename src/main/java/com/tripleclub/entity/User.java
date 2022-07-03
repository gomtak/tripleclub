package com.tripleclub.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @Column(name = "user_id")
    @Type(type="uuid-char")
    private UUID userId;
    @OneToMany(mappedBy = "user")
    private List<Mileage> mileage = new ArrayList<>();
}
