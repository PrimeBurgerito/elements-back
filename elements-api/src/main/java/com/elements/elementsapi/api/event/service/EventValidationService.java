package com.elements.elementsapi.api.event.service;

import com.elements.elementsapi.api.event.service.resource.EventDto;
import com.elements.elementsapi.api.event.service.resource.EventValidation;
import com.elements.elementsapi.api.location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventValidationService {

    private final LocationRepository locationRepository;

    EventValidation validate(EventDto eventDto) {
        EventValidation validation = new EventValidation();
        if (eventDto.getRequirement() == null || eventDto.getRequirement().getLocationId() == null) {
            validation.unAccept("locationId", "Can't be null");
        } else if (!locationRepository.existsById(eventDto.getRequirement().getLocationId())) {
            validation.unAccept("locationId", "Location doesn't exist");
        }

        if (validation.isAccepted()) {
            log.info("Event validation passed.");
        } else {
            log.error("Event validation failed - Field: {}, Reason: {}", validation.getField(), validation.getReason());
        }
        return validation;
    }
}
