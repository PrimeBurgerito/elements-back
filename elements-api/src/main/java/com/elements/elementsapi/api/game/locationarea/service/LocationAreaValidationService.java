package com.elements.elementsapi.api.game.locationarea.service;

import com.elements.elementsapi.api.game.location.repository.LocationRepository;
import com.elements.elementsapi.api.game.locationarea.repository.LocationAreaRepository;
import com.elements.elementsapi.api.game.locationarea.service.resource.LocationAreaDto;
import com.elements.elementsapi.api.shared.service.resource.ValidationContainer;
import com.elements.elementsdomain.document.location.area.LocationArea;
import com.elements.elementsdomain.document.location.area.LocationInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationAreaValidationService {
    private final static String VALIDATION_FAIL = "Location area validation failed - Field: {}, Reason: {}";
    private final static String VALIDATION_SUCCESS = "Location area validation passed.";

    private final LocationRepository locationRepository;
    private final LocationAreaRepository locationAreaRepository;

    ValidationContainer validate(LocationAreaDto locationArea) {
        ValidationContainer validation = new ValidationContainer();
        Set<String> childrenIds = locationArea.getChildren().stream().map(LocationInfo::getId).collect(toSet());
        if (locationArea.getType() == LocationArea.Type.AREA) {
            if (!locationAreaRepository.existsAllById(childrenIds)) {
                validation.unAccept("children", "all child locations must exist");
            }
        } else {
            if (!locationRepository.existsAllById(childrenIds)) {
                validation.unAccept("children", "all child locations must exist");
            }
        }
        if (locationArea.getParentAreaId() != null && !locationAreaRepository.existsById(locationArea.getParentAreaId())) {
            validation.unAccept("parentAreaId", "parent area must exist");
        }

        if (validation.isAccepted()) {
            log.info(VALIDATION_SUCCESS);
        } else {
            log.error(VALIDATION_FAIL, validation.getField(), validation.getReason());
        }
        return validation;
    }
}
