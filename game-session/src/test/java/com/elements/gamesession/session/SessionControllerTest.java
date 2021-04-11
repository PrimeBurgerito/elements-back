package com.elements.gamesession.session;

import com.elements.gamesession.session.resource.GameStateDTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.stomp.StompSession;

import java.util.concurrent.ExecutionException;

import static com.elements.gamesession.helper.AuthenticatedUserTestHelper.LOCATION_NAME;
import static com.elements.gamesession.helper.AuthenticatedUserTestHelper.USERNAME;
import static java.text.MessageFormat.format;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
class SessionControllerTest extends WebSocketTest {
    @Test
    void shouldNotConnectWithoutLoginToken() {
        assertThrows(ExecutionException.class, this::connect);
    }

    @Test
    @SneakyThrows
    void shouldConnectWithDifferentUsers() {
        authenticatedUserTestHelper.createGameState();
        StompSession session1 = authenticatedConnect();
        testSubscribe(session1);

        String testUser2 = "test_user_2";
        authenticatedUserTestHelper.createGameStateFor(testUser2);
        StompSession session2 = authenticatedConnect(testUser2);
        testSubscribe(session2);

        String testText = "TestMan";

        session1.send("/session/test", testText.getBytes());
        session2.send("/session/test", testText.getBytes());

        assertEquals(format("Hello {0} [user: {1}]", testText, USERNAME), testBlockingQueue.poll(1, SECONDS));
        assertEquals(format("Hello {0} [user: {1}]", testText, testUser2), testBlockingQueue.poll(1, SECONDS));
    }

    @Test
    @SneakyThrows
    void shouldGetGameState() {
        authenticatedUserTestHelper.createGameState();
        StompSession session = authenticatedConnect();
        setGameStateSubscribe(session);

        session.send("/session/game-state", null);

        GameStateDTO response = gameStateBlockingQueue.poll(1, SECONDS);
        assertNotNull(response);
        assertEquals(LOCATION_NAME, response.getLocation().getName());
    }

}
