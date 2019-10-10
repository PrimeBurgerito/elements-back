package com.elements.elementsdomain.aggregate.event.scene.option;

import com.elements.elementsdomain.composite.requirement.Requirement;
import lombok.Data;

@Data
public class Option {
    private Integer next;
    private String text;
    private Requirement requirement;
}
