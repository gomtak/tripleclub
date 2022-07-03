package com.tripleclub.service;

import com.tripleclub.dto.EventDto;
import com.tripleclub.entity.AttachedPhoto;
import com.tripleclub.entity.Mileage;
import com.tripleclub.entity.Review;
import com.tripleclub.entity.User;
import com.tripleclub.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;
    private final MileageRepository mileageRepository;
    private final AttachedPhotoRepository attachedPhotoRepository;

    @Transactional
    public User addEvent(EventDto eventDto) {
        Review review = Review.builder()
                .reviewId(UUID.fromString(eventDto.getReviewId()))
                .content(eventDto.getContent())
                .attachedPhotoIds(getAttachedPhoto(eventDto))
                .user(userRepository.findById(UUID.fromString(eventDto.getUserId())).orElseThrow())
                .place(placeRepository.findById(UUID.fromString(eventDto.getPlaceId())).orElseThrow())
                .build();
        review.setFirst(reviewRepository.findByPlaceId(UUID.fromString(eventDto.getPlaceId()))==null?true:false);
        reviewRepository.save(review);
        saveMileage(review);

        return userRepository.findById(UUID.fromString(eventDto.getUserId())).orElseThrow();
    }
    @Transactional
    public User modEvent(EventDto eventDto) {
        getAttachedPhoto(eventDto);
        Review review = reviewRepository.findById(UUID.fromString(eventDto.getUserId())).orElseThrow();
                review.setContent("");
                review.setAttachedPhotoIds(getAttachedPhoto(eventDto));
        reviewRepository.save(review);
        saveMileage(review);

        return userRepository.findById(UUID.fromString(eventDto.getUserId())).orElseThrow();
    }



    @Transactional
    public User deleteEvent(EventDto eventDto) {
        Review review = reviewRepository.findById(UUID.fromString(eventDto.getUserId())).orElseThrow();
        reviewRepository.delete(review);
        saveMileage(review);
        return userRepository.findById(UUID.fromString(eventDto.getUserId())).orElseThrow();
    }
    public void saveMileage(Review review){
        Mileage mileage = mileageRepository.findByReviewId(review.getReviewId()).orElse(mileage = Mileage.builder()
                .mileageId(UUID.randomUUID())
                .review(review)
                .user(review.getUser()).build());
        mileage.setPoint(review.isFirst()?review.countPoint()+1:review.countPoint());
        mileageRepository.save(mileage);
    }
    private List<AttachedPhoto> getAttachedPhoto(EventDto eventDto) {
        return eventDto.getAttachedPhotoIds()
                .stream().map(m->attachedPhotoRepository.findById(UUID.fromString(m)).orElseThrow())
                .collect(Collectors.toList());
    }

}
