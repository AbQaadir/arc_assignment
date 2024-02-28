package com.arc.propertyms.property.impl;

import com.arc.propertyms.property.Property;
import com.arc.propertyms.property.PropertyRepository;
import com.arc.propertyms.property.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    // Create a new property
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    // Update a property
    public boolean updateProperty(Long id, Property updatedProperty) {

        Optional<Property> propertyOptional = propertyRepository.findById(id);
        if (propertyOptional.isPresent()) {
            Property property = propertyOptional.get();

            property.setName(updatedProperty.getName());
            property.setDescription(updatedProperty.getDescription());
            property.setLocation(updatedProperty.getLocation());
            property.setPrice(updatedProperty.getPrice());
            property.setDate(updatedProperty.getDate());
            property.setAdminId(updatedProperty.getAdminId());
            property.setReviewId(updatedProperty.getReviewId());
            property.setImageId(updatedProperty.getImageId());

            propertyRepository.save(property);
            return true;

        }
        return false;
    }

    // Get a property by id
    public Property getProperty(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        return property;
    }

    // Delete a property
    public boolean deleteProperty(Long id) {
        try {
            propertyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Get all properties
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }
}
