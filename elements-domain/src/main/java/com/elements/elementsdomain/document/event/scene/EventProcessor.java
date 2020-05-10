package com.elements.elementsdomain.document.event.scene;

import com.elements.elementsdomain.document.event.scene.option.SceneOption;
import com.elements.elementsdomain.document.event.scene.reward.SceneReward;

public interface EventProcessor {
    void setNextSceneAfter(Scene scene);

    void setNextSceneAfter(SceneOption sceneOption);

    void setNextSceneAfter(SceneReward sceneReward);

    void convert(Scene sceneBase);

    void convert(SceneOption sceneBase);

    void convert(SceneReward sceneBase);
}
