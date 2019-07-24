package com.elements.elementsdomain.reward;

import lombok.Data;

@Data
class PropertyReward {
    private String propertyId;
    private String value;
    private RewardType type;
}
