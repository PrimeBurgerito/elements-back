package com.elements.elementsapi.api.game.location.service.mapper;

import com.elements.elementsapi.api.game.location.service.resource.LocationDto;
import com.elements.elementsapi.api.realm.resource.RealmDocumentMapper;
import com.elements.elementsdomain.document.location.Location;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface LocationMapper extends RealmDocumentMapper<LocationDto, Location> {
}
