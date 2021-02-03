package com.elements.gamesession.session.resource.gamestate.domain;

import com.elements.elementsdomain.shared.character.Character;
import com.elements.gamesession.session.crud.event.domain.SceneState;
import com.elements.gamesession.session.crud.location.domain.LocationState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameStateDTO {
    private Character character;
    private LocationState location;
    private SceneState currentScene;
}
