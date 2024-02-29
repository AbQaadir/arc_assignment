package com.arc.imageprocessingms.image;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@AllArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String response = imageService.uploadImage(file);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{imageId}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable long imageId) {
        byte[] imageData = imageService.downloadImage(imageId);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpeg")).body(imageData);
    }





}
