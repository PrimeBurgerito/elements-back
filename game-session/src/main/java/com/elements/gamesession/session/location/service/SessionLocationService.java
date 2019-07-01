package com.elements.gamesession.session.location.service;

import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.location.Location;
import com.elements.gamesession.session.location.domain.SessionLocation;
import com.elements.gamesession.session.location.domain.SessionLocationMapper;
import com.elements.gamesession.session.location.repository.SessionLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionLocationService {

    private final SessionLocationMapper mapper = new SessionLocationMapper();
    private final SessionLocationRepository repository;

    public SessionLocation getByGameState(GameState gameState) {
        Location location = repository.get(gameState.getLocationId());
        return mapper.map(location, gameState.getCharacter().getStatistics());
    }

    public SessionLocation getChangedLocation(String locationName, GameState gameState) {
        Location location = repository.getByName(locationName);
        gameState.setLocationId(location.getId());
        return mapper.map(location, gameState.getCharacter().getStatistics());
    }
}
