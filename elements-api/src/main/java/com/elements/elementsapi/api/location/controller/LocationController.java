package com.elements.elementsapi.api.location.controller;

import com.elements.elementsapi.api.location.service.LocationService;
import com.elements.elementsapi.api.location.service.resource.LocationDto;
import com.elements.elementsapi.api.shared.controller.ConditionalImageEntityController;
import com.elements.elementsdomain.document.location.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/location")
public class LocationController extends ConditionalImageEntityController<LocationDto, Location> {

    private final LocationService service;

    @Override
    protected LocationService getService() {
        return service;
    }
}
