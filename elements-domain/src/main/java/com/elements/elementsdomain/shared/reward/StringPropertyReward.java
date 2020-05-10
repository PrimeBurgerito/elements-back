package com.elements.elementsdomain.shared.reward;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class StringPropertyReward extends PropertyReward<List<String>> {
}
