package com.elements.gamesession.session;


import com.elements.elementscommon.domain.user.User;
import com.elements.elementsdomain.document.location.Location;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.crud.event.service.GameSessionEventService;
import com.elements.gamesession.session.crud.gamestate.service.GameStateService;
import com.elements.gamesession.session.crud.location.service.SessionLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@RequiredArgsConstructor
public class GameSessionService {
    private final SessionLocationService sessionLocationService;
    private final GameSessionEventService sessionEventService;
    private final GameStateService gameStateService;
    private final MongoTemplate mongoTemplate;

    public void updateForUser(GameSession gameSession, String username) {
        User user = mongoTemplate.findOne(query(where("username").is(username)), User.class);
        GameState gameState = gameStateService.getForUser(requireNonNull(user).getId());
        gameSession.setGameState(gameState);
        gameSession.setCurrentLocation(sessionLocationService.getById(gameState.getLocationId()));
    }

    public void setNewLocation(GameSession session, String locationName) {
        Location newLocation = sessionLocationService.getByName(locationName);

        sessionEventService.setNewEvent(session);

        session.getGameState().setLocationId(newLocation.getId());
        session.setCurrentLocation(newLocation);
    }

    public void updateEvent(GameSession session, Integer selectedOption) {
        if (selectedOption == null) {
            sessionEventService.update(session);
        } else {
            sessionEventService.update(session, selectedOption);
        }
    }
}
