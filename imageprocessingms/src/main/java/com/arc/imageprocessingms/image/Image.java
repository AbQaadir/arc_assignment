package com.arc.imageprocessingms.image;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "image_name")
    private String name;

    @Column(name = "image_type")
    private String type;

    @Lob
    @Column(name = "picByte", length = 1000)
    private byte[] picByte;

    @Column(name = "admin_id")
    private long adminId;

}
