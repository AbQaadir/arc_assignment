//package com.arc.imageprocessingms.image.impl;
//
//import com.arc.imageprocessingms.image.Image;
//import com.arc.imageprocessingms.image.ImageRepository;
//import com.arc.imageprocessingms.image.ImageService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.Arrays;
//
//
//
//@Service
//@RequiredArgsConstructor
//public class ImageServiceImpl implements ImageService {
//
//    private final ImageRepository imageRepository;
//
//
//    @Override
//    public boolean uploadImage(MultipartFile file) {
//        try {
//            if (file.isEmpty()) {
//                return false;
//            } else if (!Arrays.asList("image/png", "image/jpeg", "image/jpg").contains(file.getContentType())) {
//                return false;
//            } else {
//                Image img = new Image();
//
//                img.setName(file.getOriginalFilename());
//                img.setType(file.getContentType());
//                img.setPicByte(file.getBytes());
//
//                imageRepository.save(img);
//
//                return true;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//    @Override
//    public Image getImage(Long imageId) {
//        return imageRepository.findById(imageId).orElse(null);
//    }
//
//}
