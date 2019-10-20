package com.elements.elementsdomain.aggregate.event.scene;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Scene extends SceneImage {
    private static final long serialVersionUID = 2002889353809293701L;
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
