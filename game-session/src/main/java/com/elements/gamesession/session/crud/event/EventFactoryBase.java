package com.elements.gamesession.session.crud.event;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.scene.EventProcessor;
import com.elements.elementsdomain.document.event.scene.Scene;
import com.elements.elementsdomain.document.event.scene.option.Option;
import com.elements.elementsdomain.document.event.scene.option.SceneOption;
import com.elements.elementsdomain.document.event.scene.reward.SceneReward;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.gamesession.session.crud.event.domain.SceneStateDTO;
import lombok.Getter;
import lombok.Setter;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PROTECTED;

public abstract class EventFactoryBase extends EventProcessor {
    private final CharacterProperties characterProperties;

    @Getter
    private SceneStateDTO currentSceneState;

    @Setter(PROTECTED)
    private int chosenOptionIndex;

    public EventFactoryBase(Event event, CharacterProperties characterProperties) {
        super(event);
        this.characterProperties = characterProperties;
    }

    @Override
    public void setSceneIndexAfter(Scene scene) {
        currentSceneIndex = ofNullable(scene.getNext()).orElse(-1);
    }

    @Override
    public void setSceneIndexAfter(SceneOption scene) {
        boolean isSelectedOptionDisabled = currentSceneState.getOptions().get(chosenOptionIndex).isDisabled();
        if (isSelectedOptionDisabled) {
            currentSceneIndex = -1;
        } else {
            Option chosenOption = scene.getOptions().get(chosenOptionIndex);
            currentSceneIndex = ofNullable(chosenOption.getNext()).orElse(-1);
        }
    }

    @Override
    public void setSceneIndexAfter(SceneReward sceneReward) {
        currentSceneIndex = ofNullable(sceneReward.getNext()).orElse(-1);
    }

    @Override
    public void setSceneState(Scene scene) {
        currentSceneState = new SceneStateDTO(scene);
    }

    @Override
    public void setSceneState(SceneOption scene) {
        currentSceneState = new SceneStateDTO(scene, characterProperties);
    }

    @Override
    public void setSceneState(SceneReward reward) {
        currentSceneState = null;
    }
}
