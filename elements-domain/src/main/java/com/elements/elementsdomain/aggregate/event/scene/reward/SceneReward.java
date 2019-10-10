package com.elements.elementsdomain.aggregate.event.scene.reward;

import com.elements.elementsdomain.aggregate.event.scene.SceneBase;
import com.elements.elementsdomain.aggregate.event.scene.SceneProcessor;
import com.elements.elementsdomain.aggregate.event.scene.SceneType;
import com.elements.elementsdomain.composite.reward.Reward;
import lombok.Data;

@Data
public class SceneReward implements SceneBase {
    private Reward reward;
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
        return SceneType.REWARD;
    }
}
