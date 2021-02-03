package com.elements.elementsdomain.shared.requirement;

import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.querydsl.core.annotations.QueryEmbeddable;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.util.Pair;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Builder
@QueryEmbeddable
public class PropertiesRequirement implements Serializable {
    private static final long serialVersionUID = 3495875495505930239L;

    private Map<String, Set<String>> stringProperties;
    private Map<String, Pair<Float, Float>> numericProperties;

    public boolean testProperties(CharacterProperties properties) {
        boolean numericPropertiesSatisfied = testNumericProperties(properties.getNumericPropertyKeyToValue());
        boolean stringPropertiesSatisfied = testStringProperties(properties.getStringPropertyKeyToValue());
        return numericPropertiesSatisfied && stringPropertiesSatisfied;
    }

    private boolean testNumericProperties(Map<String, Float> testProperties) {
        return numericProperties == null || numericProperties.entrySet().stream().allMatch(entry -> {
            var value = entry.getValue();
            var testValue = testProperties.getOrDefault(entry.getKey(), null);
            return testValue == null || (value.getFirst() <= testValue && value.getSecond() >= testValue);
        });
    }

    private boolean testStringProperties(Map<String, List<String>> testProperties) {
        return stringProperties == null || stringProperties.entrySet().stream().allMatch(entry -> {
            var testValue = testProperties.getOrDefault(entry.getKey(), null);
            return testValue == null || testValue.containsAll(entry.getValue());
        });
    }
}
