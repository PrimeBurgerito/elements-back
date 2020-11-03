package com.elements.elementsapi.api.game.locationarea.service.mapper;

import com.elements.elementsapi.api.game.locationarea.service.resource.LocationAreaDto;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.document.location.area.LocationArea;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface LocationAreaMapper extends BaseMapper<LocationAreaDto, LocationArea> {
}
