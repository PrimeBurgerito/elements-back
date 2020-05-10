package com.elements.gamesession.session.crud.location.service;

import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.document.location.Location;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.crud.location.domain.LocationState;
import com.elements.gamesession.session.crud.location.domain.SessionLocationMapper;
import com.elements.gamesession.session.crud.location.repository.SessionLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionLocationService {

    private final SessionLocationMapper mapper;
    private final SessionLocationRepository repository;

    public LocationState getByGameState(GameState gameState) {
        Location location = repository.get(gameState.getLocationId());
        return mapper.map(location, gameState.getCharacter().getProperties());
    }

    public void setNewLocation(String locationName, GameSession gameSession) {
        GameState gameState = gameSession.getGameState();
        Location location = repository.getByName(locationName);

        gameState.setLocationId(location.getId());
        LocationState newLocation = mapper.map(location, gameState.getCharacter().getProperties());
        gameSession.getGameStateResource().setLocation(newLocation);
    }
}
