package com.elements.elementsapi.api.shared.service;

import com.elements.elementsapi.api.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.shared.service.resource.ImageDto;
import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.composite.image.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import static java.util.Optional.ofNullable;

@RequiredArgsConstructor
public abstract class ImageEntityService<D, T extends DocumentBase> extends BaseService<D, T> {

    private final FileStorageService fileStorageService;

    public Image addImage(ImageDto imageDto, MultipartFile file) {
        T entity = findById(imageDto.getEntityId());
        Image image = fileStorageService.storeImage(file);
        image.setKey(imageDto.getImageKey());
        image.setCrops(ofNullable(imageDto.getCrops()).orElse(null));
        addImageToEntity(entity, imageDto.getImageKey(), image);
        getRepository().save(entity);
        return image;
    }

    public boolean removeImage(String entityId, String imageKey) {
        T entity = findById(entityId);
        boolean removed = removeImageFromEntity(entity, imageKey);
        getRepository().save(entity);
        return removed;
    }

    protected abstract void addImageToEntity(T entity, String imageKey, Image image);

    protected abstract boolean removeImageFromEntity(T entity, String imageKey);
}
