package com.arc.propertyms.property.impl;

import com.arc.propertyms.property.Property;
import com.arc.propertyms.property.PropertyRepository;
import com.arc.propertyms.property.PropertyService;
import com.arc.propertyms.property.client.AdminClient;
import com.arc.propertyms.property.client.ImageClient;
import com.arc.propertyms.property.client.ReviewClient;
import com.arc.propertyms.property.dto.PropertyDTO;
import com.arc.propertyms.property.external.Admin;
import com.arc.propertyms.property.external.Image;
import com.arc.propertyms.property.external.Review;
import com.arc.propertyms.property.mapper.PropertyMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final ImageClient imageClient;
    private final AdminClient adminClient;
    private final ReviewClient reviewClient;

    public PropertyServiceImpl(PropertyRepository propertyRepository, ImageClient imageClient, AdminClient adminClient, ReviewClient reviewClient) {
        this.propertyRepository = propertyRepository;
        this.imageClient = imageClient;
        this.adminClient = adminClient;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<PropertyDTO> findAll() {
        List<Property> properties = propertyRepository.findAll();
        List<PropertyDTO> propertyDTOS = new ArrayList<>();

        return properties.stream().map(this::convertToDto).collect(Collectors.toList());

    }

    private PropertyDTO convertToDto(Property property) {

        Image image = imageClient.downloadImageById(property.getImageId());
        Admin admin = adminClient.getAdminById(property.getAdminId());
        Long adminId = admin.getId();

        List<Review> review = reviewClient.getAllReviews(adminId);

        return PropertyMapper.toPropertyDTO(property, image, admin, review);
    }



    // Create a new property
    @Override
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    // Update a property
    @Override
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
            property.setImageId(updatedProperty.getImageId());

            propertyRepository.save(property);
            return true;

        }
        return false;
    }

    // Get a property by id
    @Override
    public Property getProperty(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        return property;
    }

    // Delete a property
    @Override
    public boolean deleteProperty(Long id) {
        try {
            propertyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
