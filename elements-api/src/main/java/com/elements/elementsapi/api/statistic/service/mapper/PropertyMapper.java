package com.elements.elementsapi.api.statistic.service.mapper;

import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsapi.api.statistic.service.resource.PropertyDto;
import com.elements.elementsdomain.statistic.Property;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface PropertyMapper extends BaseMapper<PropertyDto, Property> {
}
