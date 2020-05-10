package com.elements.elementsapi.api.charactertemplate.service.resource;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class CharacterTemplateDto {
    private Map<String, List<String>> stringProperties;
    private Map<String, Float> numericProperties;
}
