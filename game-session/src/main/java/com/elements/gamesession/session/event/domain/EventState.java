package com.elements.gamesession.session.event.domain;

import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.event.scene.Scene;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventState {
    private Event event;
    private int currentScene;

    public EventState(Event event) {
        this.event = event;
        this.currentScene = 0;
    }

    public void nextScene() {
        setCurrentScene(currentScene + 1);
    }

    public Scene getCurrentScene() {
        return event.getScenes().get(currentScene);
    }

    public boolean isScenePossible() {
        return currentScene < event.getScenes().size();
    }
}
