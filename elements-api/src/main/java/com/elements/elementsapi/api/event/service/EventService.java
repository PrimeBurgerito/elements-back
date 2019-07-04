package com.elements.elementsapi.api.event.service;

import com.elements.elementsapi.api.event.repository.EventRepository;
import com.elements.elementsapi.api.event.service.mapper.EventMapper;
import com.elements.elementsapi.api.event.service.resource.EventDto;
import com.elements.elementsapi.api.event.service.resource.ImageToSceneMap;
import com.elements.elementsapi.api.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.image.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
public class EventService extends BaseService<EventDto, Event> {

    private final FileStorageService fileStorageService;
    private final EventRepository repository;
    private final EventMapper mapper;

    public EventService(FileStorageService fileStorageService, EventRepository repository, EventMapper mapper) {
        this.fileStorageService = fileStorageService;
        this.repository = repository;
        this.mapper = mapper;
    }

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
        imageToSceneMap.forEach(toSceneMap -> {
            MultipartFile imageFile = images[toSceneMap.getImageIndex()];
            Image image = fileStorageService.storeImage(imageFile);
            eventDto.getScenes().get(toSceneMap.getSceneIndex()).setImage(image);
        });
        return super.create(eventDto);
    }
}
