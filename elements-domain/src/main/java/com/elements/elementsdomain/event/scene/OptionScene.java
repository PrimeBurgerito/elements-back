package com.elements.elementsdomain.event.scene;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class OptionScene extends AbstractScene {
    private Set<Option> options;
}
