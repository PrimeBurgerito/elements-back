package com.elements.elementsapi.api.shared.service.resource;

import lombok.Data;

@Data
public class ValidationContainer {
    private String field;
    private String reason;
    private boolean accepted = true;

    public void unAccept(String field, String reason) {
        this.field = field;
        this.reason = reason;
        this.accepted = false;
    }
}
