package com.elements.elementsdomain.aggregate.event.scene.option;

import com.elements.elementsdomain.aggregate.event.scene.SceneImage;
import com.elements.elementsdomain.aggregate.event.scene.SceneProcessor;
import com.elements.elementsdomain.aggregate.event.scene.SceneType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SceneOption extends SceneImage {
    private static final long serialVersionUID = -989642667821306551L;
    private List<Option> options;

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
        return SceneType.OPTION;
    }
}
