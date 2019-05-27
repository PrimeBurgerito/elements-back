package com.elements.elementsapi.api.location.service.resource;

import lombok.Data;

import java.util.Set;

@Data
public class LocationDto {
    private String name;
    private Set<String> nearbyLocations;
}
