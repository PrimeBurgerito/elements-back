package com.elements.elementsapi.api.game.event.controller;

import com.elements.elementsapi.api.game.event.service.EventService;
import com.elements.elementsapi.api.game.event.service.resource.EventDto;
import com.elements.elementsapi.api.game.event.service.resource.ImageToSceneMap;
import com.elements.elementsapi.api.realm.controller.RealmDocumentController;
import com.elements.elementsdomain.document.event.Event;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/event")
public class EventController extends RealmDocumentController<EventDto, Event> {
    @PostMapping(value = "/new", consumes = {"multipart/form-data"})
    public Event create(
            @RequestPart("eventDto") @Valid @NotNull @NotBlank EventDto eventDto,
            @RequestPart(value = "imageToSceneMap", required = false) @Valid List<ImageToSceneMap> imageToSceneMap,
            @RequestPart(value = "files", required = false) @Valid MultipartFile[] files
    ) {
        return ((EventService) service).create(eventDto, files, imageToSceneMap);
    }

    @PutMapping(value = "/update/{id}", consumes = {"multipart/form-data"})
    public Event update(
            @PathVariable String id,
            @RequestPart("eventDto") @Valid @NotNull @NotBlank EventDto eventDto,
            @RequestPart(value = "imageToSceneMap", required = false) @Valid List<ImageToSceneMap> imageToSceneMap,
            @RequestPart(value = "files", required = false) @Valid MultipartFile[] files
    ) {
        return ((EventService) service).update(id, eventDto, files, imageToSceneMap);
    }
}
