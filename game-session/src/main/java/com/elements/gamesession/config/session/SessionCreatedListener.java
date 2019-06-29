package com.elements.gamesession.config.session;

import com.elements.elementscommon.domain.user.User;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.location.Location;
import com.elements.gamesession.session.ClientGameState;
import com.elements.gamesession.session.GameSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import static java.util.Objects.requireNonNull;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Slf4j
@Component
@RequiredArgsConstructor
public class SessionCreatedListener implements ApplicationListener<SessionConnectedEvent> {

    private final GameSession gameSession;
    private final MongoTemplate mongoTemplate;

    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        log.info("WebSocket Session Connected: {}", event.getMessage());
        log.info("Connect event [sessionId: {} ]", sha.getSessionId());
        if (event.getUser() != null) {
            String username = event.getUser().getName();
            User user = mongoTemplate.findOne(query(where("username").is(username)), User.class);
            GameState gameState = mongoTemplate.findOne(query(where("userId").is(user.getId())), GameState.class);
            Location location = mongoTemplate.findById(requireNonNull(gameState).getLocationId(), Location.class);
            gameSession.setGameState(gameState);
            gameSession.setLocation(location);
            gameSession.setClientGameState(getNewClientGameState());
        }
    }

    private ClientGameState getNewClientGameState() {
        ClientGameState clientGameState = new ClientGameState();
        GameState gameState = gameSession.getGameState();
        clientGameState.setCharacterStatistics(gameState.getCharacterStatistics());

        return clientGameState;
    }
}
