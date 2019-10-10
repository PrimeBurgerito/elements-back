package com.elements.elementsdomain.aggregate.location;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.composite.image.ConditionalImage;
import com.elements.elementsdomain.composite.requirement.Requirement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Location extends DocumentBase {
    @Indexed(unique = true)
    private String name;
    private Set<String> nearbyLocations;
    private Set<ConditionalImage> images;
    private Requirement requirement;
}
