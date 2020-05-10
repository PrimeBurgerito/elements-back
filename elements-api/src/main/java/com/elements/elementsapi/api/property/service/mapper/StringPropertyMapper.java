package com.elements.elementsapi.api.property.service.mapper;

import com.elements.elementsapi.api.property.service.resource.StringPropertyDto;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.document.propertytemplate.StringPropertyTemplate;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface StringPropertyMapper extends BaseMapper<StringPropertyDto, StringPropertyTemplate> {
}
