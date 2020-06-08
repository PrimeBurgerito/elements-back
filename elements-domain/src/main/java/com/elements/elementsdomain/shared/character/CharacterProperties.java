package com.elements.elementsdomain.shared.character;

import com.elements.elementsdomain.shared.property.NumericProperty;
import com.elements.elementsdomain.shared.property.Property;
import com.elements.elementsdomain.shared.property.StringProperty;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@Getter
@Builder
public class CharacterProperties implements Serializable {
    private static final long serialVersionUID = -433581898583303823L;

    private final List<NumericProperty> numericProperties;
    private final List<StringProperty> stringProperties;

    public Map<String, NumericProperty> getKeyToNumericProperty() {
        return numericProperties.stream().collect(toMap(Property::getKey, Function.identity()));
    }

    public Map<String, StringProperty> getKeyToStringProperty() {
        return stringProperties.stream().collect(toMap(Property::getKey, Function.identity()));
    }

    public Map<String, Float> getNumericPropertyKeyToValue() {
        return numericProperties.stream().collect(toMap(Property::getKey, NumericProperty::getValue));
    }

    public Map<String, List<String>> getStringPropertyKeyToValue() {
        return stringProperties.stream().collect(toMap(Property::getKey, StringProperty::getValue));
    }
}
