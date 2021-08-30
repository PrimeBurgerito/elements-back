package com.elements.elementsdomain.document.event;

import com.elements.elementsdomain.document.RealmDocument;
import com.elements.elementsdomain.document.event.scene.SceneBase;
import com.elements.elementsdomain.shared.requirement.Requirement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Event extends RealmDocument implements Serializable {
    private static final long serialVersionUID = -540853532575176084L;
    private String name;
    private Requirement requirement;
    private List<SceneBase> scenes;
}
