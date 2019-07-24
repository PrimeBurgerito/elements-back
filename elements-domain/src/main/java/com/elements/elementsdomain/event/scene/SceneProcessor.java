package com.elements.elementsdomain.event.scene;

import com.elements.elementsdomain.event.scene.option.SceneOption;
import com.elements.elementsdomain.event.scene.reward.SceneReward;

public interface SceneProcessor {
    void setNextScene(Scene scene);

    void setNextScene(SceneOption sceneOption);

    void setNextScene(SceneReward sceneReward);

    void convert(Scene sceneBase);

    void convert(SceneOption sceneBase);

    void convert(SceneReward sceneBase);
}
