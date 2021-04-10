package com.elements.elementsdomain.document.event.scene.option;

import com.elements.elementsdomain.document.event.scene.EventProcessor;
import com.elements.elementsdomain.document.event.scene.SceneImage;
import com.elements.elementsdomain.document.event.scene.SceneType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SceneOption extends SceneImage {
    private static final long serialVersionUID = -989642667821306551L;
    private List<Option> options;

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
        return SceneType.OPTION;
    }
}
