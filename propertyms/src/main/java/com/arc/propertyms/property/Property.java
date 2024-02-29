package com.arc.propertyms.property;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "property_name")
    private String name;

    @Column(name = "property_description")
    private String description;

    @Column(name = "property_location")
    private String location;

    @Column(name = "property_price")
    private String price;

    @Column(name = "property_date")
    @CreationTimestamp
    private String date;

    @Column(name = "property_image_id")
    private long imageId;

    @Column(name = "property_admin_id")
    private long adminId;

}
