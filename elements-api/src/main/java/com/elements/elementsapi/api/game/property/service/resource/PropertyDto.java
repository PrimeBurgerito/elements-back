package com.elements.elementsapi.api.game.property.service.resource;


import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.ValidationException;
import javax.validation.constraints.NotBlank;

import static java.text.MessageFormat.format;
import static org.springframework.util.StringUtils.capitalize;

@Data
@EqualsAndHashCode(callSuper = true)
abstract class PropertyDto<T> extends RealmDocumentDto {
    @NotBlank
    private String name;
    @NotBlank
    private String key;
    private T value;

    @JsonSetter
    public void setName(String name) {
        this.name = capitalize(name.toLowerCase()).strip();
    }

    @JsonSetter
    public void setValue(T value) {
        if (!isValueValid(value)) {
            throw new ValidationException(format("Value '{0}' is not valid!", value.toString()));
        }
        this.value = value;
    }

    protected abstract boolean isValueValid(T value);
}
