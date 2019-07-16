package com.elements.gamesession.session.event.domain;

import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.event.scene.SceneType;
import com.elements.elementsdomain.image.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class SessionEvent {
    private String text;
    private Image image;
    private SceneType type;
    private Set<SessionOption> options;

    @JsonIgnore
    private Event currentEvent;
}
