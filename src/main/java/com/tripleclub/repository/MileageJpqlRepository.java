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

    public int getUserMileage (String userId){
        String query = "select sum(t.point) " +
                "from " +
                "( select * from mileage where user_id = :userId "
                + "order by created_at desc) t group by t.user_id";
        return Integer.parseInt(em.createNativeQuery(query)
                .setParameter("userId", userId).getSingleResult().toString());

    }
}
