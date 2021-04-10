package com.elements.gamesession.session.crud.location.domain;

import com.elements.elementsdomain.shared.image.Image;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class LocationStateDTO {
    private final String name;
    private final Set<String> nearbyLocations;
    private final Set<Image> images;
}
