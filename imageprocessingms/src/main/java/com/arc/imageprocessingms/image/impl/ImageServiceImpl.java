package com.arc.imageprocessingms.image.impl;

import com.arc.imageprocessingms.image.*;
import com.arc.imageprocessingms.image.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final FileDataRepository fileDataRepository;

    private final String FILE_PATH = "C:\\java\\arc_assignment\\image-ecoomerce";

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

    @Override
    public String uploadImageToFileSystem(MultipartFile file) throws IOException {

        String filePath = FILE_PATH + file.getOriginalFilename();
        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath)
                .adminId(1)
                .propertyId(1)
                .build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "File uploaded successfully";
        } else {
            return "File upload failed";
        }
    }

    @Override
    public byte[] downloadImageFromFileSystem(long fileId) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findById(fileId);
        String filePath = fileData.get().getFilePath();

        byte[] imageData = Files.readAllBytes(new File(filePath).toPath());
        return imageData;
    }

}


