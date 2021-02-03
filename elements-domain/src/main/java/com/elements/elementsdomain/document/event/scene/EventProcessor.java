package com.elements.elementsdomain.document.event.scene;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.scene.option.SceneOption;
import com.elements.elementsdomain.document.event.scene.reward.SceneReward;

public abstract class EventProcessor {
    private final Event event;
    protected int currentSceneIndex;

    public EventProcessor(Event event) {
        this.event = event;
        currentSceneIndex = 0;
    }

    public SceneBase getCurrentScene() {
        return event.getScenes().get(currentSceneIndex);
    }

    protected boolean isSceneInRange() {
        return currentSceneIndex >= 0 && currentSceneIndex < event.getScenes().size();
    }

    protected void replaceSceneStateFromScene() {
        getCurrentScene().convert(this);
    }

    public abstract void setNextSceneAfter(Scene scene);

    public abstract void setNextSceneAfter(SceneOption sceneOption);

    public abstract void setNextSceneAfter(SceneReward sceneReward);

    public abstract void convert(Scene sceneBase);

    public abstract void convert(SceneOption sceneBase);

    public abstract void convert(SceneReward sceneBase);
}
