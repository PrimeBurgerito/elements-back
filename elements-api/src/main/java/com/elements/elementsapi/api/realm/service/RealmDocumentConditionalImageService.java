package com.elements.elementsapi.api.realm.service;

import com.elements.elementsapi.api.game.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import com.elements.elementsapi.api.shared.service.resource.ConditionalImageDto;
import com.elements.elementsdomain.document.RealmDocument;
import com.elements.elementsdomain.shared.image.ConditionalImage;
import com.elements.elementsdomain.shared.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import static java.util.Optional.ofNullable;

public abstract class RealmDocumentConditionalImageService<D extends RealmDocumentDto, T extends RealmDocument> extends RealmDocumentService<D, T> {
    @Autowired
    private FileStorageService fileStorageService;

    public ConditionalImage addImage(ConditionalImageDto imageDto, MultipartFile file) {
        T entity = findById(imageDto.getEntityId());
        Image image = fileStorageService.storeImage(file);
        image.setKey(imageDto.getImageKey());
        image.setCrops(ofNullable(imageDto.getCrops()).orElse(null));

        ConditionalImage conditionalImage = ConditionalImage.builder()
                .requirement(imageDto.getRequirement())
                .image(image)
                .build();

        addImageToEntity(entity, conditionalImage);
        repository.save(entity);
        return conditionalImage;
    }

    public boolean removeImage(String entityId, String imageKey) {
        T entity = findById(entityId);
        boolean removed = removeImageFromEntity(entity, imageKey);
        repository.save(entity);
        return removed;
    }

    protected abstract void addImageToEntity(T entity, ConditionalImage conditionalImage);

    protected abstract boolean removeImageFromEntity(T entity, String imageKey);
}
