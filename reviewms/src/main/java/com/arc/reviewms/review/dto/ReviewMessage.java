package com.arc.reviewms.review.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewMessage {
    private Long id;
    private String title;
    private String description;
    private String rating;
    private Long AdminId;

}
