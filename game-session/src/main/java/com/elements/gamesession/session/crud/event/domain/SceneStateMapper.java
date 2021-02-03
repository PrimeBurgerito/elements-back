package com.elements.gamesession.session.crud.event.domain;

import com.elements.elementsdomain.document.event.scene.Scene;
import com.elements.elementsdomain.document.event.scene.SceneImage;
import com.elements.elementsdomain.document.event.scene.option.SceneOption;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import lombok.experimental.UtilityClass;

import java.util.List;

import static java.util.stream.Collectors.toList;

@UtilityClass
class SceneStateMapper {

    SceneState map(Scene scene) {
        if (scene == null) {
            return null;
        }
        return getNewSessionEvent(scene);
    }

    SceneState map(SceneOption scene, CharacterProperties statistics) {
        if (scene == null) {
            return null;
        }
        SceneState sceneState = getNewSessionEvent(scene);
        sceneState.setOptions(mapSceneOptions(scene, statistics));
        return sceneState;
    }

    private SceneState getNewSessionEvent(SceneImage scene) {
        return SceneState.builder()
                .text(scene.getText())
                .image(scene.getImage())
                .type(scene.getType())
                .build();
    }

    private List<SceneStateOption> mapSceneOptions(SceneOption scene, CharacterProperties properties) {
        return scene.getOptions().stream().map(o -> {
            boolean isOptionEnabled = o.getRequirement().getProperties().testProperties(properties);
            return SceneStateOption.builder()
                    .text(o.getText())
                    .disabled(!isOptionEnabled)
                    .build();
        }).collect(toList());
    }

}
