package com.elements.gamesession.session.event.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class SessionOption {
    private String text;
    private String nextKey;
    private boolean disabled;
}
