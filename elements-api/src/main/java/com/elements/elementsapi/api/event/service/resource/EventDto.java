package com.elements.elementsapi.api.event.service.resource;

import com.elements.elementsdomain.event.scene.Scene;
import com.elements.elementsdomain.requirement.Requirement;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class EventDto {
    @NotBlank
    private String name;
    private Requirement requirement;
    private List<Scene> scenes;
}
