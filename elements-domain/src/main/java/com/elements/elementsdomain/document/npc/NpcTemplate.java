package com.elements.elementsdomain.document.npc;

import com.elements.elementsdomain.document.RealmDocument;
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
public class NpcTemplate extends RealmDocument {
    private long rank;
    private Set<ConditionalImage> images;
}
