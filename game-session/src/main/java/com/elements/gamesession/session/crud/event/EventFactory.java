package com.elements.gamesession.session.crud.event;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.scene.SceneBase;
import com.elements.elementsdomain.shared.character.CharacterProperties;

public class EventFactory extends EventFactoryBase {
    public EventFactory(Event event, CharacterProperties characterProperties) {
        super(event, characterProperties);
        replaceSceneStateFromScene();
    }

    public void nextScene() {
        setNextSceneIndex();
        replaceSceneStateFromScene();
    }

    public void nextScene(int option) {
        setChosenOptionIndex(option);
        setNextSceneIndex();
        replaceSceneStateFromScene();
    }

    private void setNextSceneIndex() {
        SceneBase scene = getCurrentScene();
        if (scene != null) {
            scene.configureNextSceneIndex(this);
        }
    }

    private void replaceSceneStateFromScene() {
        SceneBase scene = getCurrentScene();
        if (scene != null) {
            scene.setSceneState(this);
        }
    }
}
