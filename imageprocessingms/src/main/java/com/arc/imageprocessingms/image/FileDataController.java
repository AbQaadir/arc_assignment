package com.arc.imageprocessingms.image;

import com.arc.imageprocessingms.image.dto.ImageDataDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/images")
@AllArgsConstructor
public class FileDataController {

    private final ImageService imageService;

    @GetMapping
    public ResponseEntity<List<FileData>> findAllImages() {
        return ResponseEntity.ok(imageService.findAllImages());
    }


    @GetMapping("/{id}")
    public ResponseEntity<FileData> findImageById(@PathVariable long id) {
        return ResponseEntity.ok(imageService.findImageById(id));
    }



    @PostMapping
    public ResponseEntity<String> uploadImageToFileSystem(@RequestParam("file") MultipartFile file) throws IOException {
        String response = imageService.uploadImageToFileSystem(file);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/img/{id}")
    public ResponseEntity<byte[]> downloadImageById(@PathVariable long id) throws IOException {
        ImageDataDTO imageDataDTO = imageService.downloadImageById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageDataDTO.getImageData());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImageById(@PathVariable long id) {
        String response = imageService.deleteImageFromFileSystem(id);
        return ResponseEntity.ok(response);
    }


}
