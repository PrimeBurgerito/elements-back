package com.elements.gamesession.session.resource;

import com.elements.elementsdomain.shared.character.Character;
import com.elements.gamesession.session.crud.event.domain.SceneStateDTO;
import com.elements.gamesession.session.crud.location.domain.LocationStateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameStateDTO {
    private final CharacterDTO character;
    private final LocationStateDTO location;
    private final SceneStateDTO currentScene;

    public GameStateDTO(Character character, LocationStateDTO location, SceneStateDTO currentScene) {
        this.character = new CharacterDTO(character);
        this.location = location;
        this.currentScene = currentScene;
    }
}
