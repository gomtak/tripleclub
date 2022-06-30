package com.tripleclub.service;

import com.tripleclub.dto.EventDto;
import com.tripleclub.entity.Mileage;
import com.tripleclub.entity.Review;
import com.tripleclub.entity.User;
import com.tripleclub.repository.MileageRepository;
import com.tripleclub.repository.PlaceRepository;
import com.tripleclub.repository.ReviewRepository;
import com.tripleclub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;
    private final MileageRepository mileageRepository;

    @Transactional
    public User addEvent(EventDto eventDto) {
        Review review = Review.builder()
                .reviewId(eventDto.getReviewId())
                .content(eventDto.getContent())
                .attachedPhoto(eventDto.getAttachedPhotoIds())
                .user(userRepository.findById(eventDto.getUserId()).orElseThrow())
                .place(placeRepository.findById(eventDto.getPlaceId()).orElseThrow())
                .build();
        reviewRepository.save(review);
        saveMileage(review);

        return userRepository.findById(eventDto.getUserId()).orElseThrow();
    }
    @Transactional
    public User modEvent(EventDto eventDto) {
        Review review = reviewRepository.findById(eventDto.getUserId()).orElseThrow();
                review.setContent("");
                review.setAttachedPhoto(eventDto.getAttachedPhotoIds());
        reviewRepository.save(review);
        saveMileage(review);

        return userRepository.findById(eventDto.getUserId()).orElseThrow();
    }
    @Transactional
    public User deleteEvent(EventDto eventDto) {
        Review review = reviewRepository.findById(eventDto.getUserId()).orElseThrow();
        reviewRepository.delete(review);
        saveMileage(review);
        return userRepository.findById(eventDto.getUserId()).orElseThrow();
    }
    public void saveMileage(Review review){
        Mileage mileage = mileageRepository.findByReviewId(review.getReviewId())
                            .orElse(Mileage.builder()
                                .mileageId(UUID.randomUUID())
                                .point(countPoint(review))
                                .review(review)
                                .user(review.getUser()).build());
        mileageRepository.save(mileage);
    }

    private int countPoint(Review review) {
        int count = 0;
        if(review.getContent().length()>1){
            count++;
        }
        if(review.getAttachedPhoto().size()>1){
            count++;
        }
        if(placeRepository.findById(review.getPlace().getPlaceId()).isEmpty()){
            count++;
        }
        return count;
    }
}
