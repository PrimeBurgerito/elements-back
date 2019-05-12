package com.elements.elementsdomain.event.scene;

import com.elements.elementsdomain.requirement.Requirement;
import lombok.Data;

@Data
class Option {
    private String text;
    private Requirement requirement;
    private int nextScene;
}
