package com.elements.elementsdomain.composite.requirement;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.util.Pair;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class Requirement implements Serializable {
    private static final long serialVersionUID = -1465864466408195808L;
    @Indexed(sparse = true)
    private List<String> locationIds;
    private Timing timing;
    private List<String> objectives;
    private Map<String, Set<String>> properties;
    private Map<String, Pair<Float, Float>> attributes;
}
