package com.elements.elementsdomain.composite.reward;

import lombok.Data;

@Data
public class PropertyReward {
    private String propertyKey;
    private String value;
    private RewardType type;
}
