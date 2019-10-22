package com.elements.elementsdomain.aggregate.location.area;

import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.composite.image.Image;
import com.elements.elementsdomain.composite.requirement.Requirement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class LocationArea extends DocumentBase {
    @Indexed(unique = true)
    private String name;
    private Requirement requirement;
    private String parentAreaId;
    private Set<LocationInfo> children;
    private Image image;
    private Type type;

    public enum Type {
        LOCATION, AREA
    }
}
