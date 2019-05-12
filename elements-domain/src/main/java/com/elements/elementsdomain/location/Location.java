package com.elements.elementsdomain.location;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.image.ConditionalImage;
import com.elements.elementsdomain.requirement.Requirement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Location extends DocumentBase {
    private String name;
    @DBRef(lazy = true)
    @JsonIgnoreProperties(value = {"nearbyLocations"})
    private Set<Location> nearbyLocations;
    private Set<ConditionalImage> images;
    private Requirement requirement;
}
