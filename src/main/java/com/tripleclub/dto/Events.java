package com.tripleclub.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Events {
    private String type;
    private String action; /* "ADD", "MOD", "DELETE" */
    private UUID reviewId;
    private String content;
    private List<UUID> attachedPhotoIds;
    private UUID userId;
    private UUID placeId;
}
