package com.elements.elementsapi.api.game.npctemplate.service.mapper;

import com.elements.elementsapi.api.game.npctemplate.service.resource.NpcTemplateDto;
import com.elements.elementsapi.api.realm.resource.RealmDocumentMapper;
import com.elements.elementsdomain.document.npc.NpcTemplate;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface NpcTemplateMapper extends RealmDocumentMapper<NpcTemplateDto, NpcTemplate> {
}
