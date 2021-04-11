package com.elements.gamesession.session;

import com.elements.gamesession.helper.GameDataTestHelper;
import com.elements.gamesession.session.resource.GameStateDTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.stomp.StompSession;

import static com.elements.gamesession.helper.GameDataTestHelper.LOCATION_NAME;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
class SessionControllerLocationTest extends WebSocketTest {
    @Autowired
    private GameDataTestHelper gameDataTestHelper;

    @Test
    @SneakyThrows
    void shouldChangeLocation() {
        String otherLocationName = "location_2";
        gameDataTestHelper.getOrCreateLocation(otherLocationName);
        StompSession session = startSession();

        session.send("/session/game-state", null);
        GameStateDTO response = gameStateBlockingQueue.poll(1, SECONDS);
        assertNotNull(response);
        assertEquals(LOCATION_NAME, response.getLocation().getName());

        session.send("/session/change-location", otherLocationName.getBytes());
        response = gameStateBlockingQueue.poll(1, SECONDS);
        assertNotNull(response);
        assertEquals(otherLocationName, response.getLocation().getName());
    }

    private StompSession startSession() {
        authenticatedUserTestHelper.createGameState();
        StompSession session = authenticatedConnect();
        setGameStateSubscribe(session);

        return session;
    }

}
