package com.elements.elementsdomain.document.npc;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.shared.image.ConditionalImage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NpcTemplate extends DocumentBase {
    private long rank;
    private Set<ConditionalImage> images;
}
