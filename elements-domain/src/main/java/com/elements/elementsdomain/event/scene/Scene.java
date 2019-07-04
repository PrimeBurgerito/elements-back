package com.elements.elementsdomain.event.scene;

import com.elements.elementsdomain.image.Image;
import lombok.Data;

import java.util.Set;

@Data
public class Scene {
    private int next;
    private String text;
    private Image image;
    private SceneType type;
    private Set<SceneOption> options;
}
