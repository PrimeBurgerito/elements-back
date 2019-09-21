package com.elements.gamesession.session.event.domain;

import com.elements.elementsdomain.character.CharacterStatistics;
import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.event.scene.Scene;
import com.elements.elementsdomain.event.scene.SceneBase;
import com.elements.elementsdomain.event.scene.SceneProcessor;
import com.elements.elementsdomain.event.scene.option.Option;
import com.elements.elementsdomain.event.scene.option.SceneOption;
import com.elements.elementsdomain.event.scene.reward.SceneReward;
import lombok.Getter;
import lombok.Setter;

import static java.util.Optional.ofNullable;

@Setter
@Getter
public class EventState implements SceneProcessor {
    private Event event;
    private SessionEvent currentSessionEvent;
    private CharacterStatistics characterStatistics;
    private int currentSceneIndex;
    private int chosenOptionIndex;

    public EventState(Event event, CharacterStatistics characterStatistics) {
        this.event = event;
        this.characterStatistics = characterStatistics;
        currentSceneIndex = 0;
        chosenOptionIndex = 0;
        getCurrentScene().convert(this);
    }

    public void nextScene() {
        getCurrentScene().nextScene(this);
    }

    public void chooseOption(int index) {
        chosenOptionIndex = index;
        getCurrentScene().nextScene(this);
    }

    public SceneBase getCurrentScene() {
        return event.getScenes().get(currentSceneIndex);
    }

    private boolean isSceneInRange() {
        return currentSceneIndex >= 0 && currentSceneIndex < event.getScenes().size();
    }

    private void updateSessionEvent() {
        if (isSceneInRange()) {
            getCurrentScene().convert(this);
        } else {
            currentSessionEvent = null;
        }
    }

    @Override
    public void setNextSceneAfter(Scene scene) {
        setCurrentSceneIndex(ofNullable(scene.getNext()).orElse(-1));
        updateSessionEvent();
    }

    @Override
    public void setNextSceneAfter(SceneOption sceneOption) {
        if (currentSessionEvent.getOptions().get(chosenOptionIndex).isDisabled()) {
            setCurrentSceneIndex(-1);
        } else {
            Option chosenOption = sceneOption.getOptions().get(chosenOptionIndex);
            setCurrentSceneIndex(ofNullable(chosenOption.getNext()).orElse(-1));
        }
        updateSessionEvent();
    }

    @Override
    public void setNextSceneAfter(SceneReward sceneReward) {
        setCurrentSceneIndex(ofNullable(sceneReward.getNext()).orElse(-1));
        updateSessionEvent();
    }

    @Override
    public void convert(Scene scene) {
        currentSessionEvent = SessionEventMapper.map(scene);
    }

    @Override
    public void convert(SceneOption scene) {
        currentSessionEvent = SessionEventMapper.map(scene, characterStatistics);
    }

    @Override
    public void convert(SceneReward reward) {
        currentSessionEvent = null;
    }
}
