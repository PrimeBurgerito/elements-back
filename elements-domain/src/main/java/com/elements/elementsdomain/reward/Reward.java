package com.elements.elementsdomain.reward;

import lombok.Data;

import java.util.List;

@Data
public class Reward {
    private List<PropertyReward> properties;
    private List<AttributeReward> attributes;
    private List<ObjectiveReward> objectives;
}
