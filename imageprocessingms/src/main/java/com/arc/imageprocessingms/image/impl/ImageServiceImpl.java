package com.arc.imageprocessingms.image.impl;

import com.arc.imageprocessingms.image.Image;
import com.arc.imageprocessingms.image.ImageRepository;
import com.arc.imageprocessingms.image.ImageService;
import com.arc.imageprocessingms.image.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {

        Image imageData = imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .picByte(ImageUtils.compressImage(file.getBytes()))
                .adminId(1)
                .propertyId(1)
                .build());

        if (imageData != null) {
            return "Image uploaded successfully" ;
        } else {
            return "Image upload failed";
        }
    }

    @Override
    public byte[] downloadImage(long imageId) {
        Image imageData = imageRepository.findById(imageId).orElse(null);
        if (imageData != null) {
            return ImageUtils.decompressImage(imageData.getPicByte());
        } else {
            return null;
        }
    }
}
