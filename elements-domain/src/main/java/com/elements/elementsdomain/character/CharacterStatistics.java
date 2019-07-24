package com.elements.elementsdomain.character;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class CharacterStatistics {
    private Map<String, String> properties;
    private Map<String, Float> attributes;
    private List<String> objectives;
}
