package com.elements.gamesession.engine.requirement;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.Set;

@Getter
@Builder
public class RequirementTesterUserInfo {
    private String locationId;
    private Map<String, Float> attributes;
    private Map<String, String> properties;
    private Set<String> objectives;
}
