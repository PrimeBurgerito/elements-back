package com.elements.elementsapi.api.location.service.mapper;

import com.elements.elementsapi.api.location.service.resource.LocationDto;
import com.elements.elementsdomain.location.Location;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface LocationMapper {

    LocationDto map(Location location);

    List<LocationDto> map(Collection<Location> locations);

    Location map(LocationDto locationDto);
}
