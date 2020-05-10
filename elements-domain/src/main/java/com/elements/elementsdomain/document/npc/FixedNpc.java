package com.elements.elementsdomain.document.npc;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.shared.image.ConditionalImage;
import com.elements.elementsdomain.composite.npc.NpcStatistics;
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
public class FixedNpc extends DocumentBase {
    private String name;
    private NpcStatistics statistics;
    private Set<ConditionalImage> images;
}
