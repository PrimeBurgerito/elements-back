package com.elements.gamesession.session.event.repository;

import com.elements.elementsdomain.aggregate.event.Event;
import com.elements.elementsdomain.aggregate.gamestate.GameState;
import com.elements.elementsdomain.composite.character.CharacterStatistics;

import java.util.List;

public interface SessionEventRepository {
    List<Event> findByLocationAndStatistics(String locationId, CharacterStatistics statistics);
}
