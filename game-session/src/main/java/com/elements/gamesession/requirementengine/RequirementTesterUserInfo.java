package com.elements.gamesession.requirementengine;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class RequirementTesterUserInfo {
    private String locationId;
    private Map<String, Float> attributes;
    private Map<String, String> properties;
    private List<String> objectives;
}
