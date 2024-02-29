package com.arc.imageprocessingms.image;

import com.arc.imageprocessingms.image.dto.ImageDataDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    List<FileData> findAllImages();

    String uploadImageToFileSystem(MultipartFile file) throws IOException;

    ImageDataDTO downloadImageById(long id) throws IOException;

    byte[] downloadImageFromFileSystem(long id) throws IOException;

    String deleteImageFromFileSystem(long id);

    FileData findImageById(long id);
}
