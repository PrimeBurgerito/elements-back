package com.elements.gamesession.session.clientgamestate.domain;

import com.elements.elementsdomain.character.Character;
import com.elements.gamesession.session.event.domain.SessionEvent;
import com.elements.gamesession.session.location.domain.SessionLocation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientGameState {
    private Character character;
    private SessionLocation location;
    private SessionEvent currentEvent;
}
