package com.elements.elementsapi.api.game.event.service.mapper;

import com.elements.elementsapi.api.game.event.service.resource.EventDto;
import com.elements.elementsapi.api.realm.resource.RealmDocumentMapper;
import com.elements.elementsdomain.document.event.Event;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface EventMapper extends RealmDocumentMapper<EventDto, Event> {
}
