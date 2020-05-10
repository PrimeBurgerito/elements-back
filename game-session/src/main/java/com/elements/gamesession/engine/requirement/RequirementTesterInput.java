package com.elements.gamesession.engine.requirement;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Builder
public class RequirementTesterInput {
    private final String locationId;
    private final Map<String, Float> numericProperties;
    private final Map<String, List<String>> stringProperties;
    private final Set<String> objectives;
}
