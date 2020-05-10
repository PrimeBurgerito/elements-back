package com.elements.elementsapi.api.objective.service.mapper;

import com.elements.elementsapi.api.objective.service.resource.ObjectiveDto;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.document.objective.Objective;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface ObjectiveMapper extends BaseMapper<ObjectiveDto, Objective> {
}
