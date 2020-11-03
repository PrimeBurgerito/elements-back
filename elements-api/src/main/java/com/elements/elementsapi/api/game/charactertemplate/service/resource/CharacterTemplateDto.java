package com.elements.elementsapi.api.game.charactertemplate.service.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterTemplateDto {
    private Map<String, List<String>> stringProperties;
    private Map<String, Float> numericProperties;
}
