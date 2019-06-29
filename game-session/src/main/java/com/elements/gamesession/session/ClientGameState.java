package com.elements.gamesession.session;

import com.elements.elementsdomain.gamestate.CharacterStatistics;
import lombok.Data;

@Data
public class ClientGameState {
    private CharacterStatistics characterStatistics;
}
