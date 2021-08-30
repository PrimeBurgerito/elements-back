package com.elements.elementsapi.api.game.container.keycontainer.service.resource;

import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import com.elements.elementsdomain.document.container.Key;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class KeyContainerDto extends RealmDocumentDto {
    private String key;
    private Set<Key> keys;
}
