package com.elements.elementsdomain.shared.reward;

import lombok.Data;

import java.util.Set;

@Data
public class Reward {
    private Set<StringPropertyReward> stringProperties;
    private Set<NumericPropertyReward> numericProperties;
    private Set<ObjectiveReward> objectives;
}
