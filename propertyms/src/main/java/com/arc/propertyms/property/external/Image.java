package com.arc.propertyms.property.external;

import lombok.*;


@Setter
@Getter
public class Image {

    private long id;
    private String name;
    private String type;
    private byte[] imageData;
}
