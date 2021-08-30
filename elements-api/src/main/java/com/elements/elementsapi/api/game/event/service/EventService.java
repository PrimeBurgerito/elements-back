package com.elements.elementsapi.api.game.event.service;

import com.elements.elementsapi.api.game.event.service.resource.EventDto;
import com.elements.elementsapi.api.game.event.service.resource.ImageToSceneMap;
import com.elements.elementsapi.api.game.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.realm.service.RealmDocumentService;
import com.elements.elementsapi.api.shared.service.resource.ValidationContainer;
import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.scene.SceneBase;
import com.elements.elementsdomain.document.event.scene.SceneImage;
import com.elements.elementsdomain.shared.image.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ValidationException;
import java.util.List;

import static java.lang.String.format;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService extends RealmDocumentService<EventDto, Event> {

    private final static String VALIDATION_FAILED = "Validation failed - Field: %s, Reason: %s";
    private final static String REALM_ID_FAILED = "Realm id's do not match: %s != %s";
    private final FileStorageService fileStorageService;
    private final EventValidationService validationService;

    public Event create(EventDto eventDto, MultipartFile[] images, List<ImageToSceneMap> imageToSceneMap) {
        validateDto(eventDto);
        saveImages(eventDto.getScenes(), images, imageToSceneMap);
        return super.create(eventDto);
    }

    public Event update(String entityId, EventDto eventDto, MultipartFile[] images, List<ImageToSceneMap> imageToSceneMap) {
        Event event = repository.findById(entityId).orElseThrow();
        validateDto(eventDto, event);
        mapper.update(eventDto, event);
        saveImages(event.getScenes(), images, imageToSceneMap);
        return repository.save(event);
    }

    private void saveImages(List<SceneBase> scenes, MultipartFile[] images, List<ImageToSceneMap> imageToSceneMap) {
        if (imageToSceneMap == null || images == null) {
            return;
        }
        if (imageToSceneMap.size() != images.length) {
            throw new ValidationException("Images and image to scene mapper sizes don't match!");
        }
        imageToSceneMap.forEach(toSceneMap -> {
            MultipartFile imageFile = images[toSceneMap.getImageIndex()];
            Image image = fileStorageService.storeImage(imageFile);
            SceneBase scene = scenes.get(toSceneMap.getSceneIndex());
            if (scene instanceof SceneImage) {
                ((SceneImage) scene).setImage(image);
            }
        });
    }

    private void validateDto(EventDto eventDto, Event event) {
        if (!event.getRealmId().equals(eventDto.getRealmId())) {
            throw new ValidationException(format(REALM_ID_FAILED, eventDto.getRealmId(), event.getRealmId()));
        }
        validateDto(eventDto);
    }

    private void validateDto(EventDto eventDto) {
        ValidationContainer validation = validationService.validate(eventDto);
        if (!validation.isAccepted()) {
            throw new ValidationException(format(VALIDATION_FAILED, validation.getField(), validation.getReason()));
        }
    }
}
