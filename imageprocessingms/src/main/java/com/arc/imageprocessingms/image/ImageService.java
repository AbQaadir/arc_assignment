package com.arc.imageprocessingms.image;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    Image saveImage(MultipartFile image) throws IOException;
}
