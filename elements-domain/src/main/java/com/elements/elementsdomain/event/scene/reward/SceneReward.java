package com.elements.elementsdomain.event.scene.reward;

import com.elements.elementsdomain.event.scene.SceneBase;
import com.elements.elementsdomain.event.scene.SceneProcessor;
import com.elements.elementsdomain.event.scene.SceneType;
import com.elements.elementsdomain.reward.Reward;
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
