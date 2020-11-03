package com.elements.elementsapi.api.game.event.service;

import com.elements.elementsapi.api.game.event.repository.EventRepository;
import com.elements.elementsapi.api.game.event.service.mapper.EventMapper;
import com.elements.elementsapi.api.game.event.service.resource.EventDto;
import com.elements.elementsapi.api.game.event.service.resource.ImageToSceneMap;
import com.elements.elementsapi.api.game.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsapi.api.shared.service.resource.ValidationContainer;
import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.scene.SceneBase;
import com.elements.elementsdomain.document.event.scene.SceneImage;
import com.elements.elementsdomain.shared.image.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static java.lang.String.format;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService extends BaseService<EventDto, Event> {

    private final static String VALIDATION_FAILED = "Validation failed - Field: %s, Reason: %s";
    private final FileStorageService fileStorageService;
    private final EventValidationService validationService;
    private final EventRepository repository;
    private final EventMapper mapper;

    @Override
    public MongoRepository<Event, String> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<EventDto, Event> getMapper() {
        return mapper;
    }

    public Event create(EventDto eventDto, MultipartFile[] images, List<ImageToSceneMap> imageToSceneMap) {
        if (imageToSceneMap.size() != images.length) {
            throw new RuntimeException("Images and image to scene mapper sizes don't match!");
        }
        ValidationContainer validation = validationService.validate(eventDto);
        if (!validation.isAccepted()) {
            throw new RuntimeException(format(VALIDATION_FAILED, validation.getField(), validation.getReason()));
        }
        imageToSceneMap.forEach(toSceneMap -> {
            MultipartFile imageFile = images[toSceneMap.getImageIndex()];
            Image image = fileStorageService.storeImage(imageFile);
            SceneBase scene = eventDto.getScenes().get(toSceneMap.getSceneIndex());
            if (scene instanceof SceneImage) {
                ((SceneImage) scene).setImage(image);
            }
        });
        return super.create(eventDto);
    }
}
