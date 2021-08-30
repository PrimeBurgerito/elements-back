package com.elements.elementsapi.api.game.container.keycontainer.controller;

import com.elements.elementsapi.api.game.container.keycontainer.service.KeyContainerService;
import com.elements.elementsapi.api.game.container.keycontainer.service.resource.KeyContainerDto;
import com.elements.elementsapi.api.realm.controller.RealmDocumentController;
import com.elements.elementsdomain.document.container.KeyContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/key-container")
public class KeyContainerController extends RealmDocumentController<KeyContainerDto, KeyContainer> {

    @GetMapping(value = "/key/{key}")
    public KeyContainerDto getByKey(@PathVariable String key) {
        return ((KeyContainerService) service).findByKey(key);
    }

    @GetMapping(value = "/key/{keys}")
    public List<KeyContainerDto> getByKeys(@PathVariable Set<String> keys) {
        return ((KeyContainerService) service).findByKeys(keys);
    }
}
