package com.elements.gamesession.session.crud.location.domain;

import com.elements.elementsdomain.shared.image.Image;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class LocationState {
    private final String name;
    private final Set<String> nearbyLocations;
    private final Set<Image> images;
}
