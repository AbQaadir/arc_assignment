package com.arc.imageprocessingms.image.dto;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
public class ImageDataDTO {

        private long id;
        private String name;
        private String type;
        private byte[] imageData;
}
