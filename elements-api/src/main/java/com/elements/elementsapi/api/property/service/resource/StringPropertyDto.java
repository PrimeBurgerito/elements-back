package com.elements.elementsapi.api.property.service.resource;

import com.elements.elementsdomain.shared.property.StringProperty.StringPropertyType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptySet;

@Data
@EqualsAndHashCode(callSuper = true)
public class StringPropertyDto extends PropertyDto<List<String>> {
    @NotEmpty
    private Set<String> possibleValues = emptySet();
    private StringPropertyType type = StringPropertyType.MULTIPLE;

    @Override
    protected boolean isValueValid(List<String> value) {
        if (!StringPropertyType.MULTIPLE.equals(type) && value.size() > 1) {
            return false;
        }
        return possibleValues.containsAll(value);
    }
}
