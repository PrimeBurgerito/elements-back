package com.elements.elementsapi.api.location.service;

import com.elements.elementsapi.api.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.location.repository.LocationRepository;
import com.elements.elementsapi.api.location.service.mapper.LocationMapper;
import com.elements.elementsapi.api.location.service.resource.LocationDto;
import com.elements.elementsapi.api.shared.service.ConditionalImageEntityService;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.image.ConditionalImage;
import com.elements.elementsdomain.location.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocationService extends ConditionalImageEntityService<LocationDto, Location> {

    private final LocationRepository repository;
    private final LocationMapper mapper;

    public LocationService(
            FileStorageService fileStorageService,
            LocationRepository repository,
            LocationMapper mapper
    ) {
        super(fileStorageService);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MongoRepository<Location, String> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<LocationDto, Location> getMapper() {
        return mapper;
    }

    @Override
    public LocationDto update(String entityId, LocationDto entityDto) {
        Location location = findById(entityId);
        location.setName(entityDto.getName());
        return mapper.map(getRepository().save(location));
    }

    @Override
    protected void addImageToEntity(Location entity, ConditionalImage conditionalImage) {
        entity.getImages().stream()
                .filter((ConditionalImage img) -> img.getKey().equals(conditionalImage.getKey()))
                .findFirst()
                .ifPresentOrElse(
                        (ConditionalImage img) -> img = conditionalImage,
                        () -> entity.getImages().add(conditionalImage)
                );
    }

    @Override
    protected boolean removeImageFromEntity(Location entity, String imageKey) {
        return entity.getImages().removeIf(image -> imageKey.equals(image.getKey()));
    }
}
