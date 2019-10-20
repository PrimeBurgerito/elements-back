package com.elements.elementsapi.api.event.service;

import com.elements.elementsapi.api.event.service.resource.EventDto;
import com.elements.elementsapi.api.event.service.resource.EventValidation;
import com.elements.elementsapi.api.location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventValidationService {

    private final LocationRepository locationRepository;

    EventValidation validate(EventDto eventDto) {
        EventValidation validation = new EventValidation();
        if (eventDto.getRequirement() == null || isEmpty(eventDto.getRequirement().getLocationIds())) {
            validation.unAccept("locationIds", "Can't be null or empty");
        } else if (!locationRepository.existsAllById(eventDto.getRequirement().getLocationIds())) {
            validation.unAccept("locationIds", "Location doesn't exist");
        }

        if (validation.isAccepted()) {
            log.info("Event validation passed.");
        } else {
            log.error("Event validation failed - Field: {}, Reason: {}", validation.getField(), validation.getReason());
        }
        return validation;
    }
}
