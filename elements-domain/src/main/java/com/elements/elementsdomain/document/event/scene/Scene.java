package com.elements.elementsdomain.document.event.scene;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Scene extends SceneImage {
    private static final long serialVersionUID = 2002889353809293701L;
    private Integer next;

    @Override
    public void configureNextSceneIndex(EventProcessor processor) {
        processor.setSceneIndexAfter(this);
    }

    @Override
    public void setSceneState(EventProcessor processor) {
        processor.setSceneState(this);
    }

    @Override
    public SceneType getType() {
        return SceneType.DEFAULT;
    }
}
