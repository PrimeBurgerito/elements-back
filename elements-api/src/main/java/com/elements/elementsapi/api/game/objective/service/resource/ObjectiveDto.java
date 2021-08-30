package com.elements.elementsapi.api.game.objective.service.resource;

import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class ObjectiveDto extends RealmDocumentDto {
    private String value;

    @JsonSetter
    public void setValue(@NotNull String value) {
        this.value = value.strip().replace(" ", "_").toUpperCase();
    }
}
