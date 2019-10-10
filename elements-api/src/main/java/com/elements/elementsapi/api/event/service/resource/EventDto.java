package com.elements.elementsapi.api.event.service.resource;

import com.elements.elementsdomain.aggregate.event.scene.SceneBase;
import com.elements.elementsdomain.composite.requirement.Requirement;
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
