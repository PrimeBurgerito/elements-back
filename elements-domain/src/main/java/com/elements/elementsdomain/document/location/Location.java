package com.elements.elementsdomain.document.location;

import com.elements.elementsdomain.document.RealmDocument;
import com.elements.elementsdomain.shared.image.ConditionalImage;
import com.elements.elementsdomain.shared.requirement.Requirement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Data
@Document
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@CompoundIndexes({
        @CompoundIndex(name = "name_idx", def = "{'name': 1, 'realmId': 1}", unique = true)
})
public class Location extends RealmDocument {
    @Indexed
    private String name;
    private Set<String> nearbyLocations;
    private Set<ConditionalImage> images;
    private Requirement requirement;
}
