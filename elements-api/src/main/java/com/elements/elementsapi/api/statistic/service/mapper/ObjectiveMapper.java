package com.elements.elementsapi.api.statistic.service.mapper;

import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsapi.api.statistic.service.resource.ObjectiveDto;
import com.elements.elementsdomain.statistic.Objective;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface ObjectiveMapper extends BaseMapper<ObjectiveDto, Objective> {
}
