package com.elements.elementsdomain.document.container;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.shared.image.Image;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ImageContainer extends DocumentBase {
    @Indexed(unique = true)
    private String key;
    private Set<Image> images;
}
