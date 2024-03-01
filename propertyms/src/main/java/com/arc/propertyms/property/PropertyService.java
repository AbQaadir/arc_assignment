package com.arc.propertyms.property;

import com.arc.propertyms.property.dto.ReviewMessage;
import com.arc.propertyms.property.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    public List<PropertyDTO> findAll();

    public Property createProperty(Property property);

    public boolean updateProperty(Long id, Property property);

    public Property getProperty(Long id);

    public boolean deleteProperty(Long id);
    public void updatePropertyRating(ReviewMessage reviewMessage);

}
