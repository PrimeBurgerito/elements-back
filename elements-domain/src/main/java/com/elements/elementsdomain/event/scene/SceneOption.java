package com.elements.elementsdomain.event.scene;

import com.elements.elementsdomain.requirement.Requirement;
import lombok.Data;

@Data
class SceneOption {
    private int next;
    private String text;
    private Requirement requirement;
}
