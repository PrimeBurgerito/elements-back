package com.elements.elementsapi.api.shared.service;

import com.elements.elementsapi.api.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.shared.service.resource.ConditionalImageDto;
import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.image.ConditionalImage;
import com.elements.elementsdomain.image.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
public abstract class ConditionalImageEntityService<D, T extends DocumentBase> extends BaseService<D, T> {

    private final FileStorageService fileStorageService;

    public ConditionalImage addImage(ConditionalImageDto imageDto, MultipartFile file) {
        T entity = findById(imageDto.getEntityId());
        Image image = fileStorageService.storeImage(file);
        ConditionalImage conditionalImage = mapConditionalImage(imageDto, image);
        addImageToEntity(entity, conditionalImage);
        getRepository().save(entity);
        return conditionalImage;
    }

    public boolean removeImage(String entityId, String imageKey) {
        T entity = findById(entityId);
        boolean removed = removeImageFromEntity(entity, imageKey);
        getRepository().save(entity);
        return removed;
    }

    private static ConditionalImage mapConditionalImage(ConditionalImageDto imageDto, Image image) {
        ConditionalImage conditionalImage = ConditionalImage.builder()
                .fileName(image.getFileName())
                .key(imageDto.getImageKey())
                .uri(image.getUri())
                .build();
        conditionalImage.setRequirement(imageDto.getRequirement());
        return conditionalImage;
    }

    protected abstract void addImageToEntity(T entity, ConditionalImage conditionalImage);

    protected abstract boolean removeImageFromEntity(T entity, String imageKey);
}
