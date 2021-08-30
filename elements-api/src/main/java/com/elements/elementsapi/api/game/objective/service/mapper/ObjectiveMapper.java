package com.elements.elementsapi.api.game.objective.service.mapper;

import com.elements.elementsapi.api.game.objective.service.resource.ObjectiveDto;
import com.elements.elementsapi.api.realm.resource.RealmDocumentMapper;
import com.elements.elementsdomain.document.objective.Objective;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface ObjectiveMapper extends RealmDocumentMapper<ObjectiveDto, Objective> {
}
