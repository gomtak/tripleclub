package com.tripleclub.repository;

import com.tripleclub.entity.Mileage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MileageJpqlRepository {
    private final EntityManager em;

    public List<Mileage> getUserMileage (String userId){
        String query =
                "SELECT \n" +
                "    t.*\n" +
                "FROM mileage t\n" +
                "INNER JOIN\n" +
                "    (\n" +
                "    select *, MAX(created_at) AS MaxCreatedAt\n" +
                "    FROM mileage\n" +
                "    GROUP BY review_id\n" +
                "    ) sub\n" +
                "ON  t.created_at = sub.MaxCreatedAt\n" +
                "AND t.user_id = :userId";
        return em.createNativeQuery(query, Mileage.class)
                .setParameter("userId", userId)
                .getResultList();

    }
}
