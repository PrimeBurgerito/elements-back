package com.elements.gamesession.session.crud.event.domain;

import com.elements.elementsdomain.document.event.scene.SceneImage;
import com.elements.elementsdomain.document.event.scene.SceneType;
import com.elements.elementsdomain.document.event.scene.option.SceneOption;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.elementsdomain.shared.image.Image;
import lombok.Getter;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class SceneStateDTO {
    private final String text;
    private final Image image;
    private final SceneType type;
    private final List<SceneStateOptionDTO> options;

    public SceneStateDTO(SceneImage scene) {
        text = scene.getText();
        image = scene.getImage();
        type = scene.getType();
        options = null;
    }

    public SceneStateDTO(SceneOption scene, CharacterProperties statistics) {
        text = scene.getText();
        image = scene.getImage();
        type = scene.getType();
        options = mapSceneOptions(scene, statistics);
    }

    private static List<SceneStateOptionDTO> mapSceneOptions(SceneOption scene, CharacterProperties properties) {
        return scene.getOptions().stream().map(o -> {
            boolean isOptionEnabled = o.getRequirement().getProperties().testProperties(properties);
            return new SceneStateOptionDTO(o.getText(), !isOptionEnabled);
        }).collect(toList());
    }
}
