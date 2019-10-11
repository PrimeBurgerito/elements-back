package com.elements.elementsapi.api.container.imagecontainer.service;

import com.elements.elementsapi.api.container.imagecontainer.repository.ImageContainerRepository;
import com.elements.elementsapi.api.container.imagecontainer.service.mapper.ImageContainerMapper;
import com.elements.elementsapi.api.container.imagecontainer.service.resource.ImageContainerDto;
import com.elements.elementsapi.api.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.shared.service.ImageEntityService;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.aggregate.container.ImageContainer;
import com.elements.elementsdomain.composite.image.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ImageContainerService extends ImageEntityService<ImageContainerDto, ImageContainer> {

    private final ImageContainerRepository repository;
    private final ImageContainerMapper mapper;

    @Override
    public MongoRepository<ImageContainer, String> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<ImageContainerDto, ImageContainer> getMapper() {
        return mapper;
    }

    public ImageContainerService(
            FileStorageService fileStorageService,
            ImageContainerRepository repository,
            ImageContainerMapper mapper
    ) {
        super(fileStorageService);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected void addImageToEntity(ImageContainer entity, String imageKey, Image image) {
        if (entity.getImages().isEmpty()) {
            throw new RuntimeException("Image list can't be empty!");
        }
        removeImageFromEntity(entity, imageKey);
        entity.getImages().add(image);
    }

    @Override
    protected boolean removeImageFromEntity(ImageContainer entity, String imageKey) {
        return entity.getImages().removeIf(img -> img.getKey().equals(imageKey));
    }

    @Transactional(readOnly = true)
    public ImageContainerDto findByKey(String entityKey) {
        return mapper.map(repository.findByKey(entityKey));
    }

    @Transactional(readOnly = true)
    public List<ImageContainerDto> findByKeys(Set<String> keys) {
        return mapper.map(repository.findByKeyIn(keys));
    }
}
