package com.elements.gamesession.session.event.repository;

import com.elements.elementsdomain.aggregate.event.Event;
import com.elements.elementsdomain.aggregate.gamestate.GameState;

import java.util.List;

public interface SessionEventRepository {
    List<Event> findByGameState(GameState gameState);
}
