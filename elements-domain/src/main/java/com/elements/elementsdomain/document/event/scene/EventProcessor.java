package com.elements.elementsdomain.document.event.scene;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.scene.option.SceneOption;
import com.elements.elementsdomain.document.event.scene.reward.SceneReward;

public abstract class EventProcessor {
    private final Event event;
    protected int currentSceneIndex = 0;

    public EventProcessor(Event event) {
        this.event = event;
    }

    public SceneBase getCurrentScene() {
        boolean isSceneInRange = currentSceneIndex >= 0 && currentSceneIndex < event.getScenes().size();
        if (isSceneInRange) {
            return event.getScenes().get(currentSceneIndex);
        }
        return null;
    }

    public abstract void setSceneIndexAfter(Scene scene);

    public abstract void setSceneIndexAfter(SceneOption sceneOption);

    public abstract void setSceneIndexAfter(SceneReward sceneReward);

    public abstract void setSceneState(Scene sceneBase);

    public abstract void setSceneState(SceneOption sceneBase);

    public abstract void setSceneState(SceneReward sceneBase);
}
