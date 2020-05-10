package com.elements.elementsdomain.shared.character;

import com.elements.elementsdomain.shared.image.Image;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Character {
    private String name;
    private Map<String, Image> images;
    private CharacterProperties properties;
    private String templateId;
}
