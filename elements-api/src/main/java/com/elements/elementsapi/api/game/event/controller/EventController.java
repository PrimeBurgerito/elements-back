package com.elements.elementsapi.api.game.event.controller;

import com.elements.elementsapi.api.game.event.service.EventService;
import com.elements.elementsapi.api.game.event.service.resource.EventDto;
import com.elements.elementsapi.api.game.event.service.resource.ImageToSceneMap;
import com.elements.elementsapi.api.shared.controller.BaseController;
import com.elements.elementsdomain.document.event.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/event")
public class EventController extends BaseController<EventDto, Event> {

    private final EventService service;

    @Override
    protected EventService getService() {
        return service;
    }

    @PostMapping(value = "/new", consumes = {"multipart/form-data"})
    public Event create(
            @RequestPart("eventDto") @Valid EventDto eventDto,
            @RequestPart("imageToSceneMap") @Valid List<ImageToSceneMap> imageToSceneMap,
            @RequestPart("files") @Valid @NotNull @NotBlank MultipartFile[] files
    ) {
        return service.create(eventDto, files, imageToSceneMap);
    }
}
