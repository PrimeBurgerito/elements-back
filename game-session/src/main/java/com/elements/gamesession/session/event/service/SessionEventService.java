package com.elements.gamesession.session.event.service;

import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.event.domain.SessionEvent;
import com.elements.gamesession.session.event.repository.SessionEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.elements.gamesession.session.event.domain.SessionEventMapper.map;

@Service
@RequiredArgsConstructor
public class SessionEventService {

    private final SessionEventRepository repository;

    public void update(GameSession session, String sceneKey) {
        GameState gameState = session.getGameState();
        Event event = getByGameState(gameState);
        SessionEvent sessionEvent = map(event, gameState.getCharacter().getStatistics(), sceneKey);
        session.getClientGameState().setCurrentEvent(sessionEvent);
    }

    private Event getByGameState(GameState gameState) {
        List<Event> events = repository.getByGameState(gameState);
        return events.isEmpty() ? null : events.get(0);
    }
}
