package com.elements.gamesession.session.event.domain;

import com.elements.elementsdomain.event.Event;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventState {
    private Event event;
    private int currentScene;

    public EventState(Event event) {
        this.event = event;
        this.currentScene = 0;
    }
}
