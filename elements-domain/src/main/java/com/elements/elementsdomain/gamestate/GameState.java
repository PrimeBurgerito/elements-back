package com.elements.elementsdomain.gamestate;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.shared.character.Character;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GameState extends DocumentBase {
    private String userId;
    private String locationId;
    private Character character;
}
