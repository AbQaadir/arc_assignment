package com.arc.imageprocessingms.image.impl;

import com.arc.imageprocessingms.image.Image;
import com.arc.imageprocessingms.image.ImageRepository;
import com.arc.imageprocessingms.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;



@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image saveImage(MultipartFile image) throws IOException {
        String imageName = image.getOriginalFilename();

        Image newImage = new Image();

        newImage.setName(imageName);
        newImage.setType(image.getContentType());
        newImage.setPicByte(Arrays.copyOf(image.getBytes(), image.getBytes().length));

        return imageRepository.save(newImage);
    }
}
