package com.elements.elementsdomain.reward;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class Reward {
    private Set<PropertyReward> properties;
    private Set<AttributeReward> attributes;
    private Set<ObjectiveReward> objectives;
}
