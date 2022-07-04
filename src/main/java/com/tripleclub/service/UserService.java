package com.tripleclub.service;

import com.tripleclub.entity.Mileage;
import com.tripleclub.repository.MileageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final MileageRepository mileageRepository;

    public List<Mileage> getUserPoint(String userId){
        return mileageRepository.findByUserId(UUID.fromString(userId));
    }
}
