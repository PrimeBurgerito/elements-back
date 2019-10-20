package com.elements.elementsdomain.composite.requirement;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class Requirement {
    @Indexed(sparse = true)
    private List<String> locationIds;
    private Timing timing;
    private List<String> objectives;
    private Map<String, Set<String>> properties;
    private Map<String, Pair<Float, Float>> attributes;
}
