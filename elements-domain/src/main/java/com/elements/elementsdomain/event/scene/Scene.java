package com.elements.elementsdomain.event.scene;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Scene extends AbstractScene {
    private int nextScene;
}
