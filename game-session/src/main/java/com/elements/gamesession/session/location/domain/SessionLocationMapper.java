package com.elements.gamesession.session.location.domain;

import com.elements.elementsdomain.gamestate.character.CharacterStatistics;
import com.elements.elementsdomain.image.ConditionalImage;
import com.elements.elementsdomain.image.Image;
import com.elements.elementsdomain.location.Location;
import com.elements.gamesession.requirementengine.RequirementTester;
import com.elements.gamesession.requirementengine.RequirementTesterUserInfo;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

@Component
public class SessionLocationMapper {

    public SessionLocation map(Location location, CharacterStatistics statistics) {
        return SessionLocation.builder()
                .name(location.getName())
                .images(isEmpty(location.getImages()) ? null : filterImages(location.getImages(), statistics))
                .nearbyLocations(location.getNearbyLocations())
                .build();
    }

    private static Set<Image> filterImages(Set<ConditionalImage> images, CharacterStatistics statistics) {
        RequirementTester tester = new RequirementTester();
        RequirementTesterUserInfo userInfo = RequirementTesterUserInfo.builder()
                .attributes(statistics.getAttributes())
                .properties(statistics.getProperties())
                .objectives(statistics.getObjectives())
                .build();
        return images.stream()
                .filter(img -> {
                    tester.setRequirement(img.getRequirement());
                    tester.setUserInfo(userInfo);
                    return tester.isSatisfied();
                })
                .map(ConditionalImage::getImage)
                .collect(Collectors.toSet());
    }
}
