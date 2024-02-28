//package com.arc.imageprocessingms.image;
//
//
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/image")
//@AllArgsConstructor
//public class ImageController {
//
//    private final ImageService imageService;
//
//    @PostMapping
//    public ResponseEntity<String> createImage(@RequestBody Image image) {
//        boolean isImageSaved = imageService.uploadImage(image);
//        if (isImageSaved) {
//            return ResponseEntity.ok("Image created successfully");
//        }
//        return ResponseEntity.badRequest().body("Image not saved");
//    }
//}
