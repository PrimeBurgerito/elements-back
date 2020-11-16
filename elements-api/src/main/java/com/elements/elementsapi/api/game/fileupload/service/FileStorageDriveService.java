package com.elements.elementsapi.api.game.fileupload.service;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static java.util.Objects.requireNonNull;


@Slf4j
@Service
@Profile("heroku")
@RequiredArgsConstructor
public class FileStorageDriveService extends FileStorageService {
    private final Drive driveService;

    @Override
    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(requireNonNull(file.getOriginalFilename()));
        File fileMetadata = new File().setName(fileName);
        try {
            ByteArrayContent content = new ByteArrayContent(file.getContentType(), file.getBytes());
            File uploadedFile = driveService.files().create(fileMetadata, content)
                    .setFields("id")
                    .execute();
            log.info("Uploaded file [id: {}] to google drive.", uploadedFile.getId());
        } catch (IOException e) {
            log.error("File upload failed", e);
        }


        return fileName;
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            driveService.files().get(fileName)
                    .executeMediaAndDownloadTo(outputStream);
            return new ByteArrayResource(outputStream.toByteArray());
        } catch (IOException e) {
            log.info("Could not load file with id '{}'", fileName, e);
            return null;
        }
    }
}
