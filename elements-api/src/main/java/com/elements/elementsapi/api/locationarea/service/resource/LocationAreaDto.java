package com.elements.elementsapi.api.locationarea.service.resource;

import com.elements.elementsdomain.aggregate.location.area.LocationArea;
import com.elements.elementsdomain.aggregate.location.area.LocationInfo;
import com.elements.elementsdomain.composite.image.Image;
import com.elements.elementsdomain.composite.requirement.Requirement;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class LocationAreaDto {
    @NotEmpty
    private String name;
    private Requirement requirement;
    private String parentAreaId;
    private Set<LocationInfo> children;
    private Image image;
    @NotNull
    private LocationArea.Type type;
}
