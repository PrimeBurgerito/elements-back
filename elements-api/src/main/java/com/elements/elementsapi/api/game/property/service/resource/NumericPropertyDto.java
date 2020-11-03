package com.elements.elementsapi.api.game.property.service.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NumericPropertyDto extends PropertyDto<Float> {
    private float min = 0;
    private float max = 100;

    @Override
    protected boolean isValueValid(Float value) {
        return min <= value && max >= value;
    }
}
