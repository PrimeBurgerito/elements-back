package com.elements.elementsapi.api.container.imagecontainer.controller;

import com.elements.elementsapi.api.container.imagecontainer.service.ImageContainerService;
import com.elements.elementsapi.api.container.imagecontainer.service.resource.ImageContainerDto;
import com.elements.elementsapi.api.shared.controller.ImageEntityController;
import com.elements.elementsdomain.aggregate.container.ImageContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/image-container")
public class ImageContainerController extends ImageEntityController<ImageContainerDto, ImageContainer> {

    private final ImageContainerService service;

    @Override
    protected ImageContainerService getService() {
        return service;
    }

    @GetMapping(value = "/key/{key}")
    public ImageContainerDto getByKey(@PathVariable String key) {
        return service.findByKey(key);
    }

    @GetMapping(value = "/key/{keys}")
    public List<ImageContainerDto> getByKeys(@PathVariable Set<String> keys) {
        return service.findByKeys(keys);
    }
}
