package com.elements.elementsdomain.event.scene;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Scene extends SceneImage {
    private Integer next;

    @Override
    public void nextScene(SceneProcessor processor) {
        processor.setNextSceneAfter(this);
    }

    @Override
    public void convert(SceneProcessor processor) {
        processor.convert(this);
    }

    @Override
    public SceneType getType() {
        return SceneType.DEFAULT;
    }
}
