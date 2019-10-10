package com.elements.elementsapi.api.charactertemplate.service.mapper;

import com.elements.elementsapi.api.charactertemplate.service.resource.CharacterTemplateDto;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.aggregate.charactertemplate.CharacterTemplate;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface CharacterTemplateMapper extends BaseMapper<CharacterTemplateDto, CharacterTemplate> {
}
