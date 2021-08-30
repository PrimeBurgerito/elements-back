package com.elements.elementsapi.api.game.event.service.resource;

import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import com.elements.elementsdomain.document.event.scene.SceneBase;
import com.elements.elementsdomain.shared.requirement.Requirement;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class EventDto extends RealmDocumentDto {
    @NotBlank
    private String name;
    private Requirement requirement;
    private List<SceneBase> scenes;
}
