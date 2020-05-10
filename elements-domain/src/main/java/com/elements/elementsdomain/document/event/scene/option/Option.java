package com.elements.elementsdomain.document.event.scene.option;

import com.elements.elementsdomain.shared.requirement.Requirement;
import lombok.Data;

import java.io.Serializable;

@Data
public class Option implements Serializable {
    private static final long serialVersionUID = 5800402099153804680L;
    private Integer next;
    private String text;
    private Requirement requirement;
}
