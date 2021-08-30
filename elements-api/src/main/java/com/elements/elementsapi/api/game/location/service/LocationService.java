package com.elements.elementsapi.api.game.location.service;

import com.elements.elementsapi.api.game.location.repository.LocationRepository;
import com.elements.elementsapi.api.game.location.service.resource.LocationDto;
import com.elements.elementsapi.api.realm.service.RealmDocumentConditionalImageService;
import com.elements.elementsdomain.document.location.Location;
import com.elements.elementsdomain.shared.image.ConditionalImage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.collections4.CollectionUtils.*;

@Service
@Transactional
public class LocationService extends RealmDocumentConditionalImageService<LocationDto, Location> {
    @Override
    public Location create(LocationDto locationDto) {
        if (isNotEmpty(locationDto.getNearbyLocations())) {
            addToNearbyLocations(locationDto.getName(), locationDto.getNearbyLocations());
        }
        return super.create(locationDto);
    }

    @Override
    public LocationDto update(String locationId, LocationDto update) {
        Location location = findById(locationId);
        Set<String> dtoNearbyLocations = (Set<String>) emptyIfNull(update.getNearbyLocations());
        Set<String> nearbyLocations = (Set<String>) emptyIfNull(location.getNearbyLocations());
        Set<String> newNearbyLocations = (Set<String>) subtract(dtoNearbyLocations, nearbyLocations);
        Set<String> removedNearbyLocations = (Set<String>) subtract(nearbyLocations, dtoNearbyLocations);
        if (!newNearbyLocations.isEmpty()) {
            addToNearbyLocations(update.getName(), newNearbyLocations);
        }
        if (!removedNearbyLocations.isEmpty()) {
            removeFromNearbyLocations(location.getName(), removedNearbyLocations);
        }
        return mapper.map(repository.save(mapper.map(update)));
    }

    @Override
    public boolean delete(String locationId) {
        Location location = repository.findById(locationId).orElse(null);
        if (location == null) {
            return false;
        }
        if (isNotEmpty(location.getNearbyLocations())) {
            removeFromNearbyLocations(location.getName(), location.getNearbyLocations());
        }
        repository.delete(location);
        return true;
    }

    @Override
    protected void addImageToEntity(Location entity, ConditionalImage conditionalImage) {
        if (entity.getImages() == null) {
            entity.setImages(new HashSet<>());
        }
        entity.getImages().stream()
                .filter((ConditionalImage img) -> img.getImage().getKey().equals(conditionalImage.getImage().getKey()))
                .findFirst()
                .ifPresentOrElse(
                        (ConditionalImage img) -> img = conditionalImage,
                        () -> entity.getImages().add(conditionalImage)
                );
    }

    @Override
    protected boolean removeImageFromEntity(Location entity, String imageKey) {
        return entity.getImages().removeIf(image -> imageKey.equals(image.getImage().getKey()));
    }

    private void addToNearbyLocations(String locationName, Set<String> nearbyLocationNames) {
        Set<Location> nearbyLocations = ((LocationRepository) repository).findByNameIn(nearbyLocationNames);
        nearbyLocations.forEach((Location location) -> {
            if (location.getNearbyLocations() == null) {
                location.setNearbyLocations(Set.of(locationName));
            } else {
                location.getNearbyLocations().add(locationName);
            }
        });
        repository.saveAll(nearbyLocations);
    }

    private void removeFromNearbyLocations(String locationName, Set<String> nearbyLocationNames) {
        Set<Location> nearbyLocations = ((LocationRepository) repository).findByNameIn(nearbyLocationNames);
        nearbyLocations.stream()
                .filter(location -> isNotEmpty(location.getNearbyLocations()))
                .forEach(location -> location.getNearbyLocations().remove(locationName));
        repository.saveAll(nearbyLocations);
    }
}
