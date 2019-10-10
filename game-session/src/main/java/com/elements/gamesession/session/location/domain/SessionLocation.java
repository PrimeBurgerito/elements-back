package com.elements.gamesession.session.location.domain;

import com.elements.elementsdomain.composite.image.Image;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class SessionLocation {
    private String name;
    private Set<String> nearbyLocations;
    private Set<Image> images;
}
