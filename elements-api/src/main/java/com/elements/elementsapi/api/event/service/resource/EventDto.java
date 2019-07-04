package com.elements.elementsapi.api.event.service.resource;

import com.elements.elementsdomain.event.scene.Scene;
import com.elements.elementsdomain.requirement.Requirement;
import lombok.Data;

import java.util.List;

@Data
public class EventDto {
    private Requirement requirement;
    private List<Scene> scenes;
}
