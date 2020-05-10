package com.elements.elementsdomain.shared.property;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

import static com.elements.elementsdomain.shared.property.StringProperty.StringPropertyType.MULTIPLE;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

@Data
@EqualsAndHashCode(callSuper = true)
public class StringProperty extends Property<List<String>> {
    private static final long serialVersionUID = -1671438097023405614L;

    private Set<String> possibleValues;
    private StringPropertyType type = MULTIPLE;

    public enum StringPropertyType {
        SINGLE, UNIQUE, MULTIPLE
    }

    public void setValue(List<String> newValues) {
        if (type == MULTIPLE) {
            List<String> merged = concat(getValue().stream(), newValues.stream()).distinct().collect(toList());
            super.setValue(merged);
        } else {
            super.setValue(newValues.subList(0, 1));
        }
    }
}
