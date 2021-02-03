package com.elements.gamesession.session.crud.location.domain;

import com.elements.elementsdomain.document.location.Location;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.elementsdomain.shared.image.ConditionalImage;
import com.elements.elementsdomain.shared.image.Image;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Collections.emptySet;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;

@Component
public class SessionLocationMapper {

    public LocationState map(Location location, CharacterProperties statistics) {
        return LocationState.builder()
                .name(location.getName())
                .images(isEmpty(location.getImages()) ? emptySet() : filterImages(location.getImages(), statistics))
                .nearbyLocations(location.getNearbyLocations())
                .build();
    }

    private static Set<Image> filterImages(Set<ConditionalImage> images, CharacterProperties properties) {
        return images.stream()
                .filter(byRequirements(properties))
                .map(ConditionalImage::getImage)
                .collect(Collectors.toSet());
    }

    @NotNull
    private static Predicate<ConditionalImage> byRequirements(CharacterProperties properties) {
        return img -> img.getRequirement() == null
                || img.getRequirement().getProperties() == null
                || img.getRequirement().getProperties().testProperties(properties);
    }
}
