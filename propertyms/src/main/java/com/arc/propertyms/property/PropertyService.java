package com.arc.propertyms.property;

import java.util.List;

public interface PropertyService {

    public Property createProperty(Property property);

    public boolean updateProperty(Long id, Property property);

    public Property getProperty(Long id);

    public boolean deleteProperty(Long id);

    public List<Property> getAllProperties();

}
