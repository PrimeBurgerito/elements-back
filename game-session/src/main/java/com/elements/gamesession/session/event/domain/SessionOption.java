package com.elements.gamesession.session.event.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionOption {
    private String text;
    private boolean disabled;
}
