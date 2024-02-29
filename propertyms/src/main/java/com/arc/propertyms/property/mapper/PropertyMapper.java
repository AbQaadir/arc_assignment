package com.arc.propertyms.property.mapper;

import com.arc.propertyms.property.Property;
import com.arc.propertyms.property.dto.PropertyDTO;
import com.arc.propertyms.property.external.Admin;
import com.arc.propertyms.property.external.Image;
import com.arc.propertyms.property.external.Review;

import java.util.List;

public class PropertyMapper {

    public static PropertyDTO toPropertyDTO(Property property, Image image, Admin admin, List<Review> reviews) {

        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setId(property.getId());
        propertyDTO.setName(property.getName());
        propertyDTO.setDescription(property.getDescription());
        propertyDTO.setLocation(property.getLocation());
        propertyDTO.setPrice(property.getPrice());
        propertyDTO.setDate(property.getDate());
        propertyDTO.setImage(image);
        propertyDTO.setAdmin(admin);
        propertyDTO.setReviews(reviews);

        return propertyDTO;
    }


}
