package com.elements.elementsdomain.document.event.scene;

import com.elements.elementsdomain.document.event.scene.option.SceneOption;
import com.elements.elementsdomain.document.event.scene.reward.SceneReward;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = Scene.class, name = "DEFAULT"),
        @Type(value = SceneOption.class, name = "OPTION"),
        @Type(value = SceneReward.class, name = "REWARD")
})
public interface SceneBase extends Serializable {

    @JsonIgnore
    void configureNextSceneIndex(EventProcessor processor);

    @JsonIgnore
    void setSceneState(EventProcessor processor);

    SceneType getType();
}
