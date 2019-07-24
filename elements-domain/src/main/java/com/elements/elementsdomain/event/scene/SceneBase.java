package com.elements.elementsdomain.event.scene;

import com.elements.elementsdomain.event.scene.option.SceneOption;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = Scene.class, name = "DEFAULT"),
        @Type(value = SceneOption.class, name = "OPTION")
})
public interface SceneBase {
    void nextScene(SceneProcessor processor);

    void convert(SceneProcessor processor);

    SceneType getType();
}
