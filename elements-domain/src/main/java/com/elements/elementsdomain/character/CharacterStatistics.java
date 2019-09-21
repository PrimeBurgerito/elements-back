package com.elements.elementsdomain.character;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Builder
public class CharacterStatistics {
    private Map<String, String> properties;
    private Map<String, Float> attributes;
    private Set<String> objectives;
}
