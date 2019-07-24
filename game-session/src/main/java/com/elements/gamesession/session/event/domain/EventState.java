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

    private SceneBase getCurrentScene() {
        return event.getScenes().get(currentSceneIndex);
    }

    private boolean isScenePossible() {
        return currentSceneIndex >= 0 && currentSceneIndex < event.getScenes().size();
    }

    private void updateSessionEvent() {
        if (isScenePossible()) {
            getCurrentScene().convert(this);
        } else {
            currentSessionEvent = null;
        }
    }

    @Override
    public void setNextScene(Scene scene) {
        setCurrentSceneIndex(ofNullable(scene.getNext()).orElse(-1));
        updateSessionEvent();
    }

    @Override
    public void setNextScene(SceneOption sceneOption) {
        if (currentSessionEvent.getOptions().get(chosenOptionIndex).isDisabled()) {
            setCurrentSceneIndex(-1);
        } else {
            Option chosenOption = sceneOption.getOptions().get(chosenOptionIndex);
            setCurrentSceneIndex(ofNullable(chosenOption.getNext()).orElse(-1));
        }
        updateSessionEvent();
    }

    @Override
    public void setNextScene(SceneReward sceneReward) {

    }

    @Override
    public void convert(Scene sceneBase) {
        currentSessionEvent = SessionEventMapper.map(sceneBase);
    }

    @Override
    public void convert(SceneOption sceneBase) {
        currentSessionEvent = SessionEventMapper.map(sceneBase, characterStatistics);
    }

    @Override
    public void convert(SceneReward sceneBase) {
        currentSessionEvent = null;
    }
}
