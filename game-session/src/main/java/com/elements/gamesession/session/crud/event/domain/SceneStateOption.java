package com.elements.gamesession.session.crud.event.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SceneStateOption {
    private String text;
    private boolean disabled;
}
