package com.elements.elementsdomain.aggregate.event.scene;

import com.elements.elementsdomain.composite.image.Image;
import lombok.Data;

@Data
public abstract class SceneImage implements SceneBase {
    private String text;
    private Image image;
}
