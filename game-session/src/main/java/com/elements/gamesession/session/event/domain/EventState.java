package com.elements.gamesession.session.event.domain;

import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.event.scene.Scene;
import lombok.Getter;
import lombok.Setter;

import static java.util.Optional.ofNullable;

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
        setCurrentScene(ofNullable(getCurrentScene().getNext()).orElse(-1));
    }

    public void chooseOption(int index) {
        setCurrentScene(getCurrentScene().getOptions().get(index).getNext());
    }

    public Scene getCurrentScene() {
        return event.getScenes().get(currentScene);
    }

    public boolean isScenePossible() {
        return currentScene >= 0 && currentScene < event.getScenes().size();
    }
}
