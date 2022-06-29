package com.tripleclub.service;

import com.tripleclub.dto.Event;
import com.tripleclub.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EventService {
    public static final String ADD = "ADD";
    public static final String MOD = "MOD";
    public static final String DELETE = "DELETE";

    private final ReviewRepository reviewRepository;
    @Transactional
    public void callReviewEvent(Event event) {
        if(event.getAction()== ADD){

        }else if(event.getAction()== MOD){

        }else if(event.getAction()== DELETE){

        }
    }
}
