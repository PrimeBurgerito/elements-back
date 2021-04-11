package com.elements.gamesession.helper;

import com.elements.elementscommon.config.security.JwtUtils;
import com.elements.elementscommon.domain.user.User;
import com.elements.elementsdomain.document.location.Location;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.shared.character.Character;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.gamesession.session.crud.gamestate.repository.GameStateRepository;
import com.elements.gamesession.session.crud.location.repository.SessionLocationRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.elements.elementsdomain.document.location.QLocation.location;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@TestComponent
@RequiredArgsConstructor
public class AuthenticatedUserTestHelper {
    public static final String USERNAME = "test_name";
    private static final String PASSWORD = "test_password";
    public static final String LOCATION_NAME = "test_location";

    private final MongoTemplate mongoTemplate;
    private final SessionLocationRepository locationRepository;
    private final GameStateRepository gameStateRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    @Getter
    private String jwt;
    @Getter
    private User testUser;
    private Location testLocation;

    @PostConstruct
    public void afterInit() {
        testUser = createTestUser(USERNAME);
        jwt = getJwtFor(testUser);
        testLocation = createLocation();
    }

    private User createTestUser(String username) {
        User newUser = mongoTemplate.findOne(query(where("username").is(username)), User.class);
        if (newUser == null) {
            newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(passwordEncoder.encode(PASSWORD));
            newUser = mongoTemplate.insert(newUser);
        }
        return newUser;
    }

    @Transactional
    public void createGameState() {
        createGameStateFor(testUser);
    }

    @Transactional
    public void createGameStateFor(String username) {
        User newUser = createTestUser(username);
        createGameStateFor(newUser);
    }

    private void createGameStateFor(User user) {
        List<GameState> gameStates = gameStateRepository.findAllByUserId(user.getId());
        if (gameStates.isEmpty()) {
            mongoTemplate.insert(GameState.builder()
                    .character(Character.builder()
                            .name("character_name")
                            .properties(CharacterProperties.builder()
                                    .numericProperties(emptyList())
                                    .stringProperties(emptyList())
                                    .build())
                            .build())
                    .userId(user.getId())
                    .locationId(testLocation.getId())
                    .build());
        }
    }

    public String getJwtFor(String username) {
        User newUser = createTestUser(username);
        return getJwtFor(newUser);
    }

    private String getJwtFor(User user) {
        return jwtUtils.generateJwtToken(new TestingAuthenticationToken(user, null));
    }

    private Location createLocation() {
        Location savedLocation = locationRepository.findOne(location.name.eq(LOCATION_NAME)).orElse(null);
        if (savedLocation == null) {
            savedLocation = mongoTemplate.insert(Location.builder()
                    .name(LOCATION_NAME)
                    .images(emptySet())
                    .nearbyLocations(emptySet())
                    .build());
        }
        return savedLocation;
    }
}
