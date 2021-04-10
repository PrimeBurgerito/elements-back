package com.elements.gamesession.session.crud.event.util;

import lombok.Getter;

@Getter
public class SessionEventValidation {
    private String field;
    private String reason;
    private boolean valid = true;

    public void unAccept(String field, String reason) {
        this.field = field;
        this.reason = reason;
        this.valid = false;
    }
}
