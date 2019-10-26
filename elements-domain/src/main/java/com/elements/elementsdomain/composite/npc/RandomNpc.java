package com.elements.elementsdomain.composite.npc;

import com.elements.elementsdomain.composite.image.Image;
import lombok.Data;

@Data
public class RandomNpc {
    private String name;
    private NpcStatistics statistics;
    private Image image;
}
