package com.elements.elementsapi.api.game.property.service.mapper;

import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsapi.api.game.property.service.resource.NumericPropertyDto;
import com.elements.elementsdomain.document.propertytemplate.NumericPropertyTemplate;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface NumericPropertyMapper extends BaseMapper<NumericPropertyDto, NumericPropertyTemplate> {
}
