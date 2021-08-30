package com.elements.elementsapi.api.game.property.service.mapper;

import com.elements.elementsapi.api.game.property.service.resource.StringPropertyDto;
import com.elements.elementsapi.api.realm.resource.RealmDocumentMapper;
import com.elements.elementsdomain.document.propertytemplate.StringPropertyTemplate;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface StringPropertyMapper extends RealmDocumentMapper<StringPropertyDto, StringPropertyTemplate> {
}
