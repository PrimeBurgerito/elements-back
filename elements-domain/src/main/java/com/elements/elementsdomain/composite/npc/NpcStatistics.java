package com.elements.elementsdomain.composite.npc;

import lombok.Data;

import java.util.Map;

@Data
public class NpcStatistics {
    private Map<String, String> properties;
    private Map<String, Float> attributes;
}
