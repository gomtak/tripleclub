package com.tripleclub.service;

import com.tripleclub.entity.Mileage;
import com.tripleclub.repository.MileageJpqlRepository;
import com.tripleclub.repository.MileageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final MileageJpqlRepository mileageJpqlRepository;

    @Transactional(readOnly = true)
    public int getUserPoint(String userId){
        return mileageJpqlRepository.getUserMileage(userId)
                .stream()
                .mapToInt(m->m.getPoint()).sum();
    }
}
