package com.elements.elementsdomain.aggregate.container;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.composite.image.Image;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class ImageContainer extends DocumentBase {
    @Indexed(unique = true)
    private String key;
    private Set<Image> images;
}
