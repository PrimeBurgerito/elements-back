package com.elements.elementsdomain.aggregate.npc;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.composite.image.ConditionalImage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class NpcTemplate extends DocumentBase {
    private long rank;
    private Set<ConditionalImage> images;
}
