package com.elements.elementsapi.api.game.container.imagecontainer.service;

import com.elements.elementsapi.api.game.container.imagecontainer.repository.ImageContainerRepository;
import com.elements.elementsapi.api.game.container.imagecontainer.service.resource.ImageContainerDto;
import com.elements.elementsapi.api.realm.service.RealmDocumentImageService;
import com.elements.elementsdomain.document.container.ImageContainer;
import com.elements.elementsdomain.shared.image.Image;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ImageContainerService extends RealmDocumentImageService<ImageContainerDto, ImageContainer> {
    @Override
    protected void addImageToEntity(ImageContainer entity, String imageKey, Image image) {
        if (entity.getImages() == null) {
            entity.setImages(new HashSet<>());
        }
        removeImageFromEntity(entity, imageKey);
        entity.getImages().add(image);
    }

    @Override
    protected boolean removeImageFromEntity(ImageContainer entity, String imageKey) {
        return entity.getImages().removeIf(img -> img.getKey().equals(imageKey));
    }

    @Transactional(readOnly = true)
    public ImageContainer findByKey(String entityKey) {
        return ((ImageContainerRepository) repository).findByKey(entityKey);
    }

    @Transactional(readOnly = true)
    public List<ImageContainer> findByKeys(Set<String> keys) {
        return ((ImageContainerRepository) repository).findByKeyIn(keys);
    }
}
