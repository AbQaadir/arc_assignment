package com.arc.propertyms.property.external;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Review {

    private Long id;
    private String title;
    private String description;
    private String rating;
    private Long adminId;
}
