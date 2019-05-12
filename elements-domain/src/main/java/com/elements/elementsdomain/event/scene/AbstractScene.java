package com.elements.elementsdomain.event.scene;

import com.elements.elementsdomain.image.Image;
import lombok.Data;

@Data
public abstract class AbstractScene {
    private String text;
    private Image image;
}
