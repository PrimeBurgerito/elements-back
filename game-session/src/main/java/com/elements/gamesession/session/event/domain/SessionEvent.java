package com.elements.gamesession.session.event.domain;

import com.elements.elementsdomain.event.scene.SceneType;
import com.elements.elementsdomain.image.Image;
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
