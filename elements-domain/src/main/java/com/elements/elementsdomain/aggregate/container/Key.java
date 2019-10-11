package com.elements.elementsdomain.aggregate.container;

import com.mongodb.lang.NonNull;
import lombok.Data;

@Data
public class Key {
    @NonNull
    private String value;
    private boolean required = false;
}
