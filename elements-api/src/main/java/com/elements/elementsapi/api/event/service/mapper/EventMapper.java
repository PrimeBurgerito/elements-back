package com.elements.elementsapi.api.event.service.mapper;

import com.elements.elementsapi.api.event.service.resource.EventDto;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.event.Event;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface EventMapper extends BaseMapper<EventDto, Event> {
}
