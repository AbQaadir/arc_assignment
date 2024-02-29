package com.arc.imageprocessingms.image;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
@AllArgsConstructor
public class FileDataController {

    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<String> uploadImageToFileSystem(@RequestParam("file") MultipartFile file) throws IOException {
        String response = imageService.uploadImageToFileSystem(file);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<byte[]> downloadImageFromFileSystem(@PathVariable long imageId) throws IOException {
        byte[] imageData = imageService.downloadImageFromFileSystem(imageId);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpeg")).body(imageData);
    }



}
