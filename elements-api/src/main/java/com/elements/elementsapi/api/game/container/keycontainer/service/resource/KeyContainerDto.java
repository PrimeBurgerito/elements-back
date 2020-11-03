package com.elements.elementsapi.api.game.container.keycontainer.service.resource;

import com.elements.elementsdomain.document.container.Key;
import lombok.Data;

import java.util.Set;

@Data
public class KeyContainerDto {
    private String key;
    private Set<Key> keys;
}
