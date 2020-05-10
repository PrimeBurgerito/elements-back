package com.elements.gamesession.session.crud.event.domain;

import com.elements.elementsdomain.document.event.scene.SceneType;
import com.elements.elementsdomain.shared.image.Image;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SceneState {
    private String text;
    private Image image;
    private SceneType type;
    private List<SceneStateOption> options;
}
