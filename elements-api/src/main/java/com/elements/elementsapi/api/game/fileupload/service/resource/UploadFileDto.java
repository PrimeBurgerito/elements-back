package com.elements.elementsapi.api.game.fileupload.service.resource;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadFileDto {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
