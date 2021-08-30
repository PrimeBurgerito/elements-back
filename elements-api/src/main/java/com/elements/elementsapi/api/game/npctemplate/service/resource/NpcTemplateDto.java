package com.elements.elementsapi.api.game.npctemplate.service.resource;

import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NpcTemplateDto extends RealmDocumentDto {
    private long rank;
}
