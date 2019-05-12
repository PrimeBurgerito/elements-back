package com.elements.elementsdomain.event;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.event.scene.AbstractScene;
import com.elements.elementsdomain.requirement.Requirement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Event extends DocumentBase {
    private Requirement requirement;
    private AbstractScene[] scenes;
}
