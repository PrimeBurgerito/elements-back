package com.elements.gamesession.session.location.service;

import com.elements.elementsdomain.aggregate.gamestate.GameState;
import com.elements.elementsdomain.aggregate.location.Location;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.location.domain.SessionLocation;
import com.elements.gamesession.session.location.domain.SessionLocationMapper;
import com.elements.gamesession.session.location.repository.SessionLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionLocationService {

    private final SessionLocationMapper mapper;
    private final SessionLocationRepository repository;

    public SessionLocation getByGameState(GameState gameState) {
        Location location = repository.get(gameState.getLocationId());
        return mapper.map(location, gameState.getCharacter().getStatistics());
    }

    public void update(String locationName, GameSession gameSession) {
        GameState gameState = gameSession.getGameState();
        Location location = repository.getByName(locationName);

        gameState.setLocationId(location.getId());
        SessionLocation newLocation = mapper.map(location, gameState.getCharacter().getStatistics());
        gameSession.getClientGameState().setLocation(newLocation);
    }
}
