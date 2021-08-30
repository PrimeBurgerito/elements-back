package com.elements.elementsapi.api.game.container.imagecontainer.service.mapper;

import com.elements.elementsapi.api.game.container.imagecontainer.service.resource.ImageContainerDto;
import com.elements.elementsapi.api.realm.resource.RealmDocumentMapper;
import com.elements.elementsdomain.document.container.ImageContainer;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface ImageContainerMapper extends RealmDocumentMapper<ImageContainerDto, ImageContainer> {
}
