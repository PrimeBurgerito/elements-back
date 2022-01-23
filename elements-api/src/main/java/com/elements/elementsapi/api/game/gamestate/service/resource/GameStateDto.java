package com.elements.elementsapi.api.game.gamestate.service.resource;

import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GameStateDto extends RealmDocumentDto {
    private String characterTemplateId;
    private String characterName;
}
