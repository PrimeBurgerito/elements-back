package com.elements.gamesession.session.crud.location.domain;

import com.elements.elementsdomain.document.location.Location;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.elementsdomain.shared.image.ConditionalImage;
import com.elements.elementsdomain.shared.image.Image;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Collections.emptySet;

@UtilityClass
public class SessionLocationMapper {

    public static LocationStateDTO map(Location location, CharacterProperties statistics) {
        Set<Image> images = location.getImages() == null ? emptySet() : filterImages(location.getImages(), statistics);
        return new LocationStateDTO(location.getName(), location.getNearbyLocations(), images);
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
