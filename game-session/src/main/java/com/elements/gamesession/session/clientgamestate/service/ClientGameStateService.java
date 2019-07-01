package com.elements.gamesession.session.clientgamestate.service;

import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.clientgamestate.domain.ClientGameState;
import com.elements.gamesession.session.location.domain.SessionLocation;
import com.elements.gamesession.session.location.service.SessionLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientGameStateService {

    private final SessionLocationService locationService;

    public ClientGameState get(GameState gameState) {
        SessionLocation location = locationService.getByGameState(gameState);
        return ClientGameState.builder()
                .character(gameState.getCharacter())
                .location(location)
                .build();
    }
}
