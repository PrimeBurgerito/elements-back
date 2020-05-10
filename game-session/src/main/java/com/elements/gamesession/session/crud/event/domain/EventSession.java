package com.elements.gamesession.session.crud.event.domain;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.scene.EventProcessor;
import com.elements.elementsdomain.document.event.scene.Scene;
import com.elements.elementsdomain.document.event.scene.SceneBase;
import com.elements.elementsdomain.document.event.scene.option.Option;
import com.elements.elementsdomain.document.event.scene.option.SceneOption;
import com.elements.elementsdomain.document.event.scene.reward.SceneReward;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import lombok.Getter;

import static java.util.Optional.ofNullable;


@Getter
public class EventSession implements EventProcessor {
    private final Event event;
    private SceneState currentSceneState;
    private final CharacterProperties characterProperties;
    private int currentSceneIndex;
    private int chosenOptionIndex;

    public EventSession(Event event, CharacterProperties characterProperties) {
        this.event = event;
        this.characterProperties = characterProperties;
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
            currentSceneState = null;
        }
    }

    @Override
    public void setNextSceneAfter(Scene scene) {
        currentSceneIndex = ofNullable(scene.getNext()).orElse(-1);
        updateSessionEvent();
    }

    @Override
    public void setNextSceneAfter(SceneOption sceneOption) {
        if (currentSceneState.getOptions().get(chosenOptionIndex).isDisabled()) {
            currentSceneIndex = -1;
        } else {
            Option chosenOption = sceneOption.getOptions().get(chosenOptionIndex);
            currentSceneIndex = ofNullable(chosenOption.getNext()).orElse(-1);
        }
        updateSessionEvent();
    }

    @Override
    public void setNextSceneAfter(SceneReward sceneReward) {
        currentSceneIndex = ofNullable(sceneReward.getNext()).orElse(-1);
        updateSessionEvent();
    }

    @Override
    public void convert(Scene scene) {
        currentSceneState = SceneStateMapper.map(scene);
    }

    @Override
    public void convert(SceneOption scene) {
        currentSceneState = SceneStateMapper.map(scene, characterProperties);
    }

    @Override
    public void convert(SceneReward reward) {
        currentSceneState = null;
    }
}
