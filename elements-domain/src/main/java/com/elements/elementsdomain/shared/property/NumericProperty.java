package com.elements.elementsdomain.shared.property;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NumericProperty extends Property<Float> {
    private static final long serialVersionUID = -813293908292982179L;

    private float min;
    private float max;

    public void setValue(Float newValue) {
        if (newValue < min) {
            super.setValue(min);
        } else if (newValue > max) {
            super.setValue(max);
        } else {
            super.setValue(newValue);
        }
    }
}
