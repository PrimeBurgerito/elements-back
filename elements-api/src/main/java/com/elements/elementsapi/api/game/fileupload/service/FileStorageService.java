package com.elements.elementsapi.api.game.fileupload.service;

import com.elements.elementsdomain.shared.image.Image;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public abstract class FileStorageService {

    public Image storeImage(MultipartFile file) {
        String fileName = storeFile(file);
        return Image.builder()
                .fileName(fileName)
                .build();
    }

    public abstract String storeFile(MultipartFile file);

    public abstract Resource loadFileAsResource(String fileName);
}
