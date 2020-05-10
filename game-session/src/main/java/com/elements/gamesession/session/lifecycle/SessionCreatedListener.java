package com.elements.gamesession.session.lifecycle;

import com.elements.elementscommon.domain.user.User;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.resource.gamestate.service.GameStateResourceBuilder;
import com.elements.gamesession.session.crud.gamestate.service.GameStateService;
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
    private final GameStateService gameStateService;
    private final GameStateResourceBuilder gameStateResourceBuilder;

    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        log.info("WebSocket Session Connected: {}", event.getMessage());
        log.info("Connect event [sessionId: {} ]", sha.getSessionId());
        if (event.getUser() != null) {
            String username = event.getUser().getName();
            User user = mongoTemplate.findOne(query(where("username").is(username)), User.class);
            GameState gameState = gameStateService.get(requireNonNull(user).getId());

            gameSession.setGameState(gameState);
            gameSession.setGameStateResource(gameStateResourceBuilder.build(gameState));
        }
    }
}
