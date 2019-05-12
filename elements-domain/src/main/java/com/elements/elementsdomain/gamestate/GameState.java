package com.elements.elementsdomain.gamestate;

import com.elements.elementscommon.domain.DocumentBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class GameState extends DocumentBase {
    private String userId;
    private String locationId;
    private String characterTemplateId;
    private CharacterStatistics characterStatistics;
}
