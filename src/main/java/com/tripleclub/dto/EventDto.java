package com.tripleclub.dto;

import com.tripleclub.entity.AttachedPhoto;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class EventDto {
    private String type;
    private String action; /* "ADD", "MOD", "DELETE" */

    private UUID reviewId;
    private String content;
    private List<AttachedPhoto> attachedPhotoIds;
    private UUID userId;
    private UUID placeId;
}
