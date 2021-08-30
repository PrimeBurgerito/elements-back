package com.elements.elementsdomain.document.item;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.elements.elementsdomain.document.item.ItemType.CLOTHING;

@Data
@Document
@SuperBuilder
@NoArgsConstructor
@TypeAlias("clothing")
@EqualsAndHashCode(callSuper = true)
public class Clothing extends Item {
    private ClothingType clothingType;

    @Override
    public ItemType getType() {
        return CLOTHING;
    }

    public enum ClothingType {
        HEAD,
        BODY,
        UNDERWEAR,
        ACCESSORY,
    }
}
