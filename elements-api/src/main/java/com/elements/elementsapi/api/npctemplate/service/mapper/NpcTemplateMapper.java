package com.elements.elementsapi.api.npctemplate.service.mapper;

import com.elements.elementsapi.api.npctemplate.service.resource.NpcTemplateDto;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.document.npc.NpcTemplate;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface NpcTemplateMapper extends BaseMapper<NpcTemplateDto, NpcTemplate> {
}
