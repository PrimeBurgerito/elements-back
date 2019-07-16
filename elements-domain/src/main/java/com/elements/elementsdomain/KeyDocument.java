package com.elements.elementsdomain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import static java.lang.String.valueOf;

@Data
public abstract class KeyDocument {
    @Id
    private String key;

    protected KeyDocument() {
        key = valueOf(ObjectId.get());
    }
}
