package com.elements.elementsapi.api.statistic.service.mapper;

import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsapi.api.statistic.service.resource.AttributeDto;
import com.elements.elementsdomain.aggregate.statistic.Attribute;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface AttributeMapper extends BaseMapper<AttributeDto, Attribute> {
}
