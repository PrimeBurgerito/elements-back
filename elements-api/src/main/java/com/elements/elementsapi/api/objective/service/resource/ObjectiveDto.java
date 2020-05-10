package com.elements.elementsapi.api.objective.service.resource;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class ObjectiveDto {
    private String value;

    @JsonSetter
    public void setValue(@NotNull String value) {
        this.value = value.strip().replace(" ", "_").toUpperCase();
    }
}
