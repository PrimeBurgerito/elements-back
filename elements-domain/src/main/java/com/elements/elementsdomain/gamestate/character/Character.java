package com.elements.elementsdomain.gamestate.character;

import com.elements.elementsdomain.image.Image;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Character {
    private String name;
    private Map<String, Image> images;
    private CharacterStatistics statistics;
}
