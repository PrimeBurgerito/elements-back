package com.elements.elementsdomain.document.propertytemplate;

import com.elements.elementsdomain.shared.property.StringProperty;
import com.elements.elementsdomain.shared.property.StringProperty.StringPropertyType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class StringPropertyTemplate extends PropertyTemplate<List<String>, StringProperty> {
    private Set<String> possibleValues;
    private StringPropertyType type = StringPropertyType.MULTIPLE;

    @Override
    public StringProperty toProperty(@Nullable List<String> value) {
        StringProperty property = new StringProperty();
        property.setPossibleValues(possibleValues);
        property.setType(type);
        property.setKey(getKey());
        property.setName(getName());
        property.setValue(getValue());
        return property;
    }
}
