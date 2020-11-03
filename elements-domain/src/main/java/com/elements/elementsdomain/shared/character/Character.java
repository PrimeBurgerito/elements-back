package com.elements.elementsdomain.shared.character;

import com.elements.elementsdomain.document.item.Item;
import com.elements.elementsdomain.shared.image.Image;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
@Builder
public class Character {
    private String name;
    private String templateId;
    private CharacterProperties properties;
    private Map<String, Image> images;
    private List<Item> items;
    private CharacterEquipment equipment;
}
