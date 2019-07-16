package com.elements.elementsdomain.event.scene;

import com.elements.elementsdomain.KeyDocument;
import com.elements.elementsdomain.image.Image;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Scene extends KeyDocument {
    private int next;
    private String nextKey;
    private String text;
    private Image image;
    private SceneType type;
    private List<SceneOption> options;
}
