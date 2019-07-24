package com.elements.elementsdomain.event.scene.option;

import com.elements.elementsdomain.event.scene.SceneImage;
import com.elements.elementsdomain.event.scene.SceneProcessor;
import com.elements.elementsdomain.event.scene.SceneType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SceneOption extends SceneImage {
    private List<Option> options;

    @Override
    public void nextScene(SceneProcessor processor) {
        processor.setNextScene(this);
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
