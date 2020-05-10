package com.elements.gamesession.session.crud.location.domain;

import com.elements.elementsdomain.document.location.Location;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.elementsdomain.shared.image.ConditionalImage;
import com.elements.elementsdomain.shared.image.Image;
import com.elements.gamesession.engine.requirement.RequirementTester;
import com.elements.gamesession.engine.requirement.RequirementTesterInput;
import org.springframework.stereotype.Component;

import java.util.Set;
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
        RequirementTesterInput input = RequirementTesterInput.builder()
                .numericProperties(properties.getNumericPropertyKeyToValue())
                .stringProperties(properties.getStringPropertyKeyToValue())
                .objectives(emptySet()) // TODO
                .build();

        RequirementTester tester = new RequirementTester(input);

        return images.stream()
                .filter(img -> tester.isSatisfied(img.getRequirement()))
                .map(ConditionalImage::getImage)
                .collect(Collectors.toSet());
    }
}
