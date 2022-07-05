package com.tripleclub.service;

import com.tripleclub.dto.EventDto;
import com.tripleclub.dto.UserDto;
import com.tripleclub.entity.AttachedPhoto;
import com.tripleclub.entity.Mileage;
import com.tripleclub.entity.Review;
import com.tripleclub.entity.User;
import com.tripleclub.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
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
        Review review = saveReview(eventDto);

        saveAttachedPhoto(eventDto, review);

        saveMileage(review);

        return userRepository.findById(UUID.fromString(eventDto.getUserId())).orElseThrow();
    }



    @Transactional
    public User modEvent(EventDto eventDto) {
        Review review = reviewRepository.findById(UUID.fromString(eventDto.getReviewId())).orElseThrow();

        review.modifyReview(eventDto.getContent());
        reviewRepository.save(review);

        attachedPhotoRepository.deleteByReviewId(review.getReviewId());
        saveAttachedPhoto(eventDto, review);

        saveMileage(review);

        return userRepository.findById(UUID.fromString(eventDto.getUserId())).orElseThrow();
    }

    @Transactional
    public User deleteEvent(EventDto eventDto) {
        Review review = reviewRepository.findById(UUID.fromString(eventDto.getReviewId())).orElseThrow();

        attachedPhotoRepository.deleteByReviewId(review.getReviewId());

        mileageRepository.deleteAllByReviewId(review.getReviewId());

        reviewRepository.delete(review);

        return userRepository.findById(UUID.fromString(eventDto.getUserId())).orElseThrow();
    }

    private Review saveReview(EventDto eventDto) {
        Review review = Review.builder()
                .reviewId(UUID.fromString(eventDto.getReviewId()))
                .content(eventDto.getContent())
                .user(userRepository.findById(UUID.fromString(eventDto.getUserId())).orElseThrow())
                .place(placeRepository.findById(UUID.fromString(eventDto.getPlaceId())).orElseThrow())
                .build();
        review.setBonus(reviewRepository.findByPlaceId(UUID.fromString(eventDto.getPlaceId())));
        return reviewRepository.save(review);
    }
    private void saveAttachedPhoto(EventDto eventDto, Review review) {
        Iterable<AttachedPhoto> attachedPhotoList =
                eventDto.getAttachedPhotoIds()
                        .stream()
                        .map(m->AttachedPhoto.builder()
//                        .attachedPhotoId(UUID.fromString(m))  // 예시 UUID 길이가 36자리를 넘는 문제가 있음.
                                .attachedPhotoId(m)
                                .review(review)
                                .build())
                        .collect(Collectors.toList());
        attachedPhotoRepository.saveAll(attachedPhotoList);
    }
    public void saveMileage(Review review){
        Mileage mileage = Mileage.builder()
                .mileageId(UUID.randomUUID())
                .review(review)
                .user(review.getUser())
                .point(countPoint(review))
                .build();
        mileageRepository.save(mileage);
    }

    private int countPoint(Review review) {
        int result = 0;
        if(review.getContent().length() > 0) result++;
        if(review.isBonus()) result++;
        if(attachedPhotoRepository.findByReviewId(review.getReviewId()).size()>0) result++;
        return result;
    }


    public UserDto setResponseEntity(User user) {
        return UserDto.builder()
                .userId(user.getUserId().toString())
                .name(user.getUserName())
                .mileageList(mileageRepository.findByUserId(user.getUserId()))
                .build();
    }
}
