package com.elements.elementsapi.api.locationarea.service;

import com.elements.elementsapi.api.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.locationarea.repository.LocationAreaRepository;
import com.elements.elementsapi.api.locationarea.service.mapper.LocationAreaMapper;
import com.elements.elementsapi.api.locationarea.service.resource.LocationAreaDto;
import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementsapi.api.shared.service.resource.ValidationContainer;
import com.elements.elementsdomain.document.location.area.LocationArea;
import com.elements.elementsdomain.shared.image.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import static java.lang.String.format;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationAreaService extends BaseService<LocationAreaDto, LocationArea> {

    private final static String VALIDATION_FAILED = "Validation failed - Field: %s, Reason: %s";
    private final FileStorageService fileStorageService;
    private final LocationAreaValidationService validationService;
    private final LocationAreaRepository repository;
    private final LocationAreaMapper mapper;

    @Override
    public LocationAreaRepository getRepository() {
        return repository;
    }

    @Override
    protected LocationAreaMapper getMapper() {
        return mapper;
    }


    public LocationArea create(LocationAreaDto locationAreaDto, MultipartFile file) {
        ValidationContainer validation = validationService.validate(locationAreaDto);
        if (!validation.isAccepted()) {
            throw new RuntimeException(format(VALIDATION_FAILED, validation.getField(), validation.getReason()));
        }
        Image image = fileStorageService.storeImage(file);
        locationAreaDto.setImage(image);
        return super.create(locationAreaDto);
    }
}
