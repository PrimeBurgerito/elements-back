package com.elements.elementsdomain.event.scene;

import com.elements.elementsdomain.KeyDocument;
import com.elements.elementsdomain.requirement.Requirement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SceneOption extends KeyDocument {
    private int next;
    private String nextKey;
    private String text;
    private Requirement requirement;
}
