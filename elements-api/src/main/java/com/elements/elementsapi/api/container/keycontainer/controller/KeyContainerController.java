package com.elements.elementsapi.api.container.keycontainer.controller;

import com.elements.elementsapi.api.container.keycontainer.service.KeyContainerService;
import com.elements.elementsapi.api.container.keycontainer.service.resource.KeyContainerDto;
import com.elements.elementsapi.api.shared.controller.BaseController;
import com.elements.elementsdomain.aggregate.container.KeyContainer;
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
public class KeyContainerController extends BaseController<KeyContainerDto, KeyContainer> {

    private final KeyContainerService service;

    @Override
    protected KeyContainerService getService() {
        return service;
    }

    @GetMapping(value = "/key/{key}")
    public KeyContainerDto getByKey(@PathVariable String key) {
        return service.findByKey(key);
    }

    @GetMapping(value = "/key/{keys}")
    public List<KeyContainerDto> getByKeys(@PathVariable Set<String> keys) {
        return service.findByKeys(keys);
    }
}
