package com.elements.elementsdomain.shared.property;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Property<T> implements Serializable {
    private static final long serialVersionUID = -3256338426382910018L;

    private T value;
    private String key;
    private String name;
}
