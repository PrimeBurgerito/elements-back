package com.elements.elementsapi.api.statistic.controller;

import com.elements.elementsapi.api.shared.controller.BaseController;
import com.elements.elementsapi.api.statistic.service.PropertyService;
import com.elements.elementsapi.api.statistic.service.resource.PropertyDto;
import com.elements.elementsdomain.statistic.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/property")
public class PropertyController extends BaseController<PropertyDto, Property> {

    private final PropertyService service;

    @Override
    protected PropertyService getService() {
        return service;
    }
}
