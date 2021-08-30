package com.elements.elementsapi.api.game.container.imagecontainer.controller;

import com.elements.elementsapi.api.game.container.imagecontainer.service.ImageContainerService;
import com.elements.elementsapi.api.game.container.imagecontainer.service.resource.ImageContainerDto;
import com.elements.elementsapi.api.realm.controller.RealmDocumentImageController;
import com.elements.elementsdomain.document.container.ImageContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/image-container")
public class ImageContainerController extends RealmDocumentImageController<ImageContainerDto, ImageContainer> {

    @GetMapping(value = "/key/{key}")
    public ImageContainer getByKey(@PathVariable String key) {
        return ((ImageContainerService) service).findByKey(key);
    }

    @GetMapping(value = "/keys/{keys}")
    public List<ImageContainer> getByKeys(@PathVariable Set<String> keys) {
        return ((ImageContainerService) service).findByKeys(keys);
    }
}
