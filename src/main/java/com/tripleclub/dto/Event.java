package com.tripleclub.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Event {
    private String type;
    private String action; /* "ADD", "MOD", "DELETE" */
    private String reviewId;
    private String content;
    private List<String> attachedPhotoIds;
    private String userId;
    private String placeId;
}
