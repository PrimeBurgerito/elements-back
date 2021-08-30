package com.elements.elementsapi.api.game.location.service.resource;

import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocationDto extends RealmDocumentDto {
    private String name;
    private Set<String> nearbyLocations;
}
