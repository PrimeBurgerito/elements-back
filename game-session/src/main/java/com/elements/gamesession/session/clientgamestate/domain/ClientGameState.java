package com.elements.gamesession.session.clientgamestate.domain;

import com.elements.elementsdomain.event.scene.Scene;
import com.elements.elementsdomain.gamestate.character.Character;
import com.elements.gamesession.session.event.domain.SessionEvent;
import com.elements.gamesession.session.event.domain.SessionEventMapper;
import com.elements.gamesession.session.location.domain.SessionLocation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientGameState {
    private Character character;
    private SessionLocation location;
    private SessionEvent currentEvent;

    public void updateCurrentEvent(Scene scene) {
        currentEvent = SessionEventMapper.map(scene, character.getStatistics());
    }
}
