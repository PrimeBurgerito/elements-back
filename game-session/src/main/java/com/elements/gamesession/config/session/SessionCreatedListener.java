package com.elements.gamesession.config.session;

import com.elements.elementscommon.domain.user.User;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.location.Location;
import com.elements.gamesession.session.GameSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
@RequiredArgsConstructor
public class SessionCreatedListener implements ApplicationListener<SessionConnectedEvent> {

    private final GameSession gameSession;
    private final MongoTemplate mongoTemplate;

    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GameState gameState = mongoTemplate.findOne(query(where("userId").is(user.getId())), GameState.class);
        Location location = mongoTemplate.findById(gameState.getLocationId(), Location.class);
        gameSession.setGameState(gameState);
        gameSession.setLocation(location);
    }
}
