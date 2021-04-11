package com.elements.gamesession.session.resource;

import com.elements.elementsdomain.document.item.Item;
import com.elements.elementsdomain.shared.character.Character;
import com.elements.elementsdomain.shared.character.CharacterEquipment;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.elementsdomain.shared.image.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class CharacterDTO {
    private final String name;
    private final String templateId;
    private final CharacterProperties properties;
    private final Map<String, Image> images;
    private final List<Item> items;
    private final CharacterEquipment equipment;

    public CharacterDTO(Character character) {
        this.name = character.getName();
        this.templateId = character.getTemplateId();
        this.properties = character.getProperties();
        this.images = character.getImages();
        this.items = character.getItems();
        this.equipment = character.getEquipment();
    }
}
