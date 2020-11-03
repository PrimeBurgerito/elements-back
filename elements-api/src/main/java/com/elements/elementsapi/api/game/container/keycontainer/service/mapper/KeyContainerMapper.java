package com.elements.elementsapi.api.game.container.keycontainer.service.mapper;

import com.elements.elementsapi.api.game.container.keycontainer.service.resource.KeyContainerDto;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.document.container.KeyContainer;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface KeyContainerMapper extends BaseMapper<KeyContainerDto, KeyContainer> {
}
