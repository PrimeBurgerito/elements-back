package com.elements.elementsapi.api.realm.service;

import com.elements.elementsapi.api.game.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import com.elements.elementsapi.api.shared.service.resource.ImageDto;
import com.elements.elementsdomain.document.RealmDocument;
import com.elements.elementsdomain.shared.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import static java.util.Optional.ofNullable;

public abstract class RealmDocumentImageService<D extends RealmDocumentDto, T extends RealmDocument> extends RealmDocumentService<D, T> {

    @Autowired
    private FileStorageService fileStorageService;

    public Image addImage(ImageDto imageDto, MultipartFile file) {
        T entity = findById(imageDto.getEntityId());
        Image image = fileStorageService.storeImage(file);
        image.setKey(imageDto.getImageKey());
        image.setCrops(ofNullable(imageDto.getCrops()).orElse(null));
        addImageToEntity(entity, imageDto.getImageKey(), image);
        repository.save(entity);
        return image;
    }

    public boolean removeImage(String entityId, String imageKey) {
        T entity = findById(entityId);
        boolean removed = removeImageFromEntity(entity, imageKey);
        repository.save(entity);
        return removed;
    }

    protected abstract void addImageToEntity(T entity, String imageKey, Image image);

    protected abstract boolean removeImageFromEntity(T entity, String imageKey);
}
