package com.elements.elementsdomain.shared.reward;

import lombok.Data;

@Data
public abstract class PropertyReward<T> {
    private String propertyKey;
    private RewardType type;
    private T value;
}
