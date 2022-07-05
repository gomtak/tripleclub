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
        String query = "select * " +
                "from " +
                "( select * from mileage where user_id = :userId "
                + "order by created_at desc) t group by t.review_id";
        return em.createNativeQuery(query, Mileage.class)
                .setParameter("userId", userId)
                .getResultList();

    }
}
