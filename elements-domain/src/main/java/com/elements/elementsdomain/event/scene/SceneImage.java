package com.elements.elementsdomain.event.scene;

import com.elements.elementsdomain.image.Image;
import lombok.Data;

@Data
public abstract class SceneImage implements SceneBase {
    private String text;
    private Image image;
}
