package com.elements.gamesession.session.resource.gamestate.service;

import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.resource.gamestate.domain.GameStateResource;
import com.elements.gamesession.session.crud.location.domain.LocationState;
import com.elements.gamesession.session.crud.location.service.SessionLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameStateResourceBuilder {

    private final SessionLocationService locationService;

    public GameStateResource build(GameState gameState) {
        LocationState location = locationService.getByGameState(gameState);
        return GameStateResource.builder()
                .character(gameState.getCharacter())
                .location(location)
                .build();
    }
}
