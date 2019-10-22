package com.elements.elementsapi.api.locationarea.controller;

import com.elements.elementsapi.api.locationarea.service.LocationAreaService;
import com.elements.elementsapi.api.locationarea.service.resource.LocationAreaDto;
import com.elements.elementsapi.api.shared.controller.BaseController;
import com.elements.elementsdomain.aggregate.location.area.LocationArea;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/location-area")
public class LocationAreaController extends BaseController<LocationAreaDto, LocationArea> {

    private final LocationAreaService service;

    @Override
    protected LocationAreaService getService() {
        return service;
    }

    @PostMapping(value = "/new", consumes = {"multipart/form-data"})
    public LocationArea create(
            @RequestPart("locationDto") @Valid LocationAreaDto locationDto,
            @RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file
    ) {
        return service.create(locationDto, file);
    }
}
