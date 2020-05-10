package com.elements.elementsdomain.document.event.scene.reward;

import com.elements.elementsdomain.document.event.scene.SceneBase;
import com.elements.elementsdomain.document.event.scene.EventProcessor;
import com.elements.elementsdomain.document.event.scene.SceneType;
import com.elements.elementsdomain.shared.reward.Reward;
import lombok.Data;

@Data
public class SceneReward implements SceneBase {
    private static final long serialVersionUID = -1584226771781553895L;
    private Reward reward;
    private Integer next;

    @Override
    public void nextScene(EventProcessor processor) {
        processor.setNextSceneAfter(this);
    }

    @Override
    public void convert(EventProcessor processor) {
        processor.convert(this);
    }

    @Override
    public SceneType getType() {
        return SceneType.REWARD;
    }
}
