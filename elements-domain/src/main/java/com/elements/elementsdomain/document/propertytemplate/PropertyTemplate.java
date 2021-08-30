package com.elements.elementsdomain.document.propertytemplate;

import com.elements.elementsdomain.document.RealmDocument;
import com.elements.elementsdomain.shared.property.Property;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class PropertyTemplate<T, P extends Property<T>> extends RealmDocument {
    @Indexed(unique = true)
    private String key;
    private String name;
    private T value;

    public abstract P toProperty(@Nullable T value);

    public P toProperty() {
        return toProperty(null);
    }
}
