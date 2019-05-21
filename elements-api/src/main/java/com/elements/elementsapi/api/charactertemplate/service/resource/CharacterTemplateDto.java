package com.elements.elementsapi.api.charactertemplate.service.resource;

import lombok.Data;

import java.util.Map;

@Data
public class CharacterTemplateDto {
    private Map<String, String> properties;
    private Map<String, Float> attributes;
}
