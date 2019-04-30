package com.elements.elementsapi.api.location.controller;

import com.elements.elementsapi.api.location.service.LocationService;
import com.elements.elementsapi.api.location.service.resource.LocationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/location")
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public LocationDto create(@RequestBody LocationDto locationDto) {
        return locationService.create(locationDto);
    }

    @GetMapping
    public List<LocationDto> find() {
        return locationService.find();
    }
}
