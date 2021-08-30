package com.elements.elementsapi.api.game.charactertemplate.service.resource;

import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CharacterTemplateDto extends RealmDocumentDto {
    private Map<String, List<String>> stringProperties;
    private Map<String, Float> numericProperties;
}
