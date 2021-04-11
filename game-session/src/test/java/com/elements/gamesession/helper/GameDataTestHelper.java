package com.elements.gamesession.helper;

import com.elements.elementsdomain.document.location.Location;
import com.elements.gamesession.session.crud.location.repository.SessionLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import static com.elements.elementsdomain.document.location.QLocation.location;
import static java.util.Collections.emptySet;

@TestComponent
@RequiredArgsConstructor
public class GameDataTestHelper {
    public static final String LOCATION_NAME = "test_location";
    public static Location TEST_LOCATION;


    private final MongoTemplate mongoTemplate;
    private final SessionLocationRepository locationRepository;

    @PostConstruct
    public void afterInit() {
        mongoTemplate.dropCollection(Location.class);
        TEST_LOCATION = getOrCreateLocation();
    }

    @Transactional
    public Location getOrCreateLocation() {
        return getOrCreateLocation(LOCATION_NAME);
    }

    @Transactional
    public Location getOrCreateLocation(String locationName) {
        Location savedLocation = locationRepository.findOne(location.name.eq(locationName)).orElse(null);
        if (savedLocation == null) {
            savedLocation = mongoTemplate.insert(Location.builder()
                    .name(locationName)
                    .images(emptySet())
                    .nearbyLocations(emptySet())
                    .build());
        }
        return savedLocation;
    }
}
