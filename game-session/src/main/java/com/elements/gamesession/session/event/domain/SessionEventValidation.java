package com.elements.gamesession.session.event.domain;

import lombok.Data;

@Data
public class SessionEventValidation {
    private String field;
    private String reason;
    private boolean correct = true;

    public void unAccept(String field, String reason) {
        this.field = field;
        this.reason = reason;
        this.correct = false;
    }
}
