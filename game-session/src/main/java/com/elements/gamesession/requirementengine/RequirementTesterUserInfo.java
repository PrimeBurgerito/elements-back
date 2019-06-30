package com.elements.gamesession.requirementengine;

import com.elements.elementsdomain.statistic.ObjectiveValue;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class RequirementTesterUserInfo {
    private String locationId;
    private Map<String, Float> attributes;
    private Map<String, String> properties;
    private Map<String, ObjectiveValue> objectives;
}
