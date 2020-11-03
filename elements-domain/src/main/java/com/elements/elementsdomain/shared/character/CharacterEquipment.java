package com.elements.elementsdomain.shared.character;

import com.elements.elementsdomain.document.item.Clothing;
import com.elements.elementsdomain.document.item.Clothing.ClothingType;
import com.elements.elementsdomain.document.item.Weapon;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class CharacterEquipment {
    private Weapon weapon;
    private Map<ClothingType, Clothing> clothing = new HashMap<>();
}
