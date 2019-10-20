package com.elements.elementsdomain.aggregate.event.scene;

import com.elements.elementsdomain.composite.image.Image;
import lombok.Data;

@Data
public abstract class SceneImage implements SceneBase {
    private static final long serialVersionUID = -6768145869275735852L;
    private String text;
    private Image image;
}
