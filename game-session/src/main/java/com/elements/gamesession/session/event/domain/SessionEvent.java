package com.elements.gamesession.session.event.domain;

import com.elements.elementsdomain.aggregate.event.scene.SceneType;
import com.elements.elementsdomain.composite.image.Image;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SessionEvent {
    private String text;
    private Image image;
    private SceneType type;
    private List<SessionOption> options;
}
