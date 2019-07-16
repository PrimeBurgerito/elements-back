package com.elements.elementsdomain.event.scene;

import com.elements.elementsdomain.image.Image;
import lombok.Data;

import java.util.List;

@Data
public class Scene {
    private int next;
    private String text;
    private Image image;
    private SceneType type;
    private List<SceneOption> options;
}
