package com.elements.elementsdomain.character;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.image.Image;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class CharacterTemplate extends DocumentBase {
    private Map<String, String> properties;
    private Map<String, Float> attributes;
    private Map<String, Image> images;
}
