package com.elements.elementsdomain.document.item;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@SuperBuilder
@NoArgsConstructor
@TypeAlias("weapon")
@EqualsAndHashCode(callSuper = true)
public class Weapon extends Item {
    private WeaponType weaponType;

    @Override
    public ItemType getType() {
        return ItemType.WEAPON;
    }

    public enum WeaponType {
        SWORD,
        STAFF,
        BOW,
        DAGGER,
    }
}
