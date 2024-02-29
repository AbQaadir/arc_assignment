package com.arc.imageprocessingms.image.impl;

import com.arc.imageprocessingms.image.*;
import com.arc.imageprocessingms.image.dto.ImageDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final FileDataRepository fileDataRepository;

    private final String FILE_PATH = "C:\\java\\arc_assignment\\image-ecoomerce";

    @Override
    public List<FileData> findAllImages() {
        return fileDataRepository.findAll();
    }

    @Override
    public FileData findImageById(long id) {
        return fileDataRepository.findById(id).orElse(null);
    }


    @Override
    public String uploadImageToFileSystem(MultipartFile file) throws IOException {

        String filePath = FILE_PATH + file.getOriginalFilename();
        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath)
                .build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "File uploaded successfully";
        } else {
            return "File upload failed";
        }
    }


    @Override
    public ImageDataDTO downloadImageById(long id) throws IOException {

        Optional<FileData> fileData = fileDataRepository.findById(id);
        String filePath = fileData.get().getFilePath();
        byte[] imageData = Files.readAllBytes(new File(filePath).toPath());

        ImageDataDTO imageDataDTO = new ImageDataDTO();
        imageDataDTO.setId(id);
        imageDataDTO.setName(fileData.get().getName());
        imageDataDTO.setType(fileData.get().getType());
        imageDataDTO.setImageData(imageData);

        return imageDataDTO;
    }

    @Override
    public byte[] downloadImageFromFileSystem(long id) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findById(id);
        String filePath = fileData.get().getFilePath();

        byte[] imageData = Files.readAllBytes(new File(filePath).toPath());
        return imageData;
    }

    @Override
    public String deleteImageFromFileSystem(long id) {
        Optional<FileData> fileData = fileDataRepository.findById(id);
        String filePath = fileData.get().getFilePath();
        File file = new File(filePath);
        if (file.delete()) {
            fileDataRepository.deleteById(id);
            return "File deleted successfully";
        } else {
            return "File deletion failed";
        }
    }
}


