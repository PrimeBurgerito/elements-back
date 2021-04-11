package com.elements.gamesession.helper;

import com.elements.elementscommon.config.security.JwtUtils;
import com.elements.elementscommon.domain.user.User;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.shared.character.Character;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.gamesession.session.crud.gamestate.repository.GameStateRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@TestComponent
@RequiredArgsConstructor
public class AuthenticatedUserTestHelper {
    public static final String TEST_USERNAME = "test_name";
    private static final String PASSWORD = "test_password";

    public static User TEST_USER;

    private final MongoTemplate mongoTemplate;
    private final GameStateRepository gameStateRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final GameDataTestHelper gameDataTestHelper;

    @Getter
    private String jwt;

    @PostConstruct
    public void afterInit() {
        mongoTemplate.dropCollection(GameState.class);
        TEST_USER = createTestUser(TEST_USERNAME);
        jwt = getJwtFor(TEST_USER);
    }

    @Transactional
    public void createGameState() {
        createGameStateFor(TEST_USER);
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
                    .locationId(gameDataTestHelper.getOrCreateLocation().getId())
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
}
