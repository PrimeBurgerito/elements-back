package com.elements.elementsdomain.document.propertytemplate;

import com.elements.elementsdomain.shared.property.NumericProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class NumericPropertyTemplate extends PropertyTemplate<Float, NumericProperty> {
    private float min;
    private float max;

    @Override
    public NumericProperty toProperty(@Nullable Float value) {
        NumericProperty property = new NumericProperty();
        property.setMax(max);
        property.setMin(min);
        property.setKey(getKey());
        property.setName(getName());
        property.setValue(value == null ? getValue() : value);
        return property;
    }
}
