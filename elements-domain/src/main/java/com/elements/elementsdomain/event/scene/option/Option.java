package com.elements.elementsdomain.event.scene.option;

import com.elements.elementsdomain.requirement.Requirement;
import lombok.Data;

@Data
public class Option {
    private Integer next;
    private String text;
    private Requirement requirement;
}
