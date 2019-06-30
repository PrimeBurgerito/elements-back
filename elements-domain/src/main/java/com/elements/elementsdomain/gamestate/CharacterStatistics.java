package com.elements.elementsdomain.gamestate;

import com.elements.elementsdomain.image.Image;
import com.elements.elementsdomain.statistic.ObjectiveValue;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CharacterStatistics {
    private Map<String, String> properties;
    private Map<String, Float> attributes;
    private Map<String, Image> images;
    private Map<String, ObjectiveValue> objectives;
}
