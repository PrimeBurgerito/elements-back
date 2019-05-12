package com.elements.elementsdomain.requirement;

import com.elements.elementsdomain.statistic.ObjectiveValue;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.util.Pair;

import java.util.Map;
import java.util.Set;

@Data
public class Requirement {
    @Indexed(sparse = true)
    private String locationId;
    private Timing timing;
    private Map<String, ObjectiveValue> objectives;
    private Map<String, Set<String>> properties;
    private Map<String, Pair<Float, Float>> attributes;
}
