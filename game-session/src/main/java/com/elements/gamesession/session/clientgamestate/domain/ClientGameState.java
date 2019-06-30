package com.elements.gamesession.session.clientgamestate.domain;

import com.elements.elementsdomain.gamestate.CharacterStatistics;
import com.elements.gamesession.session.location.domain.SessionLocation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientGameState {
    private CharacterStatistics characterStatistics;
    private SessionLocation location;
}
