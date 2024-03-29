package com.elements.elementsdomain.document.charactertemplate;

import com.elements.elementsdomain.document.RealmDocument;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.elementsdomain.shared.image.Image;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CharacterTemplate extends RealmDocument {
    private Map<String, Image> images;
    private CharacterProperties properties;
}
