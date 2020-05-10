package com.elements.elementsapi.api.property.service.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NumericPropertyDto extends PropertyDto<Float> {
    private float min = 0;
    private float max = 100;

    @Override
    protected boolean isValueValid() {
        return min <= getValue() && max >= getValue();
    }
}
