package com.arc.propertyms.property.dto;

import com.arc.propertyms.property.external.Admin;
import com.arc.propertyms.property.external.Image;
import com.arc.propertyms.property.external.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PropertyDTO {

    private Long id;
    private String name;
    private String description;
    private String location;
    private String price;
    private String date;
    private Image image;
    private Admin admin;
    private List<Review> reviews;

}
