package com.elements.elementsdomain.event;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.event.scene.Scene;
import com.elements.elementsdomain.requirement.Requirement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Event extends DocumentBase {
    private String name;
    private Requirement requirement;
    private List<Scene> scenes;
}
