package com.elements.gamesession.session.crud.event.repository;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.shared.character.CharacterProperties;

import java.util.List;

public interface SessionEventRepository {
    List<Event> findByLocationAndProperties(String locationId, CharacterProperties statistics);
}
