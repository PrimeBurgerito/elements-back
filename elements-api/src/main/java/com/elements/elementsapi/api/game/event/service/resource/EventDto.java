package com.elements.elementsapi.api.game.event.service.resource;

import com.elements.elementsdomain.document.event.scene.SceneBase;
import com.elements.elementsdomain.shared.requirement.Requirement;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class EventDto {
    @NotBlank
    private String name;
    private Requirement requirement;
    private List<SceneBase> scenes;
}
