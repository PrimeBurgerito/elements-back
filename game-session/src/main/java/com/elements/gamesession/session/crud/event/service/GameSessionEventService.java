package com.elements.gamesession.session.crud.event.service;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.crud.event.EventFactory;
import com.elements.gamesession.session.crud.event.repository.SessionEventRepository;
import com.elements.gamesession.session.crud.event.util.SessionEventUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.elements.gamesession.session.crud.event.util.SessionEventUtil.createEventFactory;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GameSessionEventService {
    private final SessionEventRepository repository;

    public void setNewEvent(GameSession session) {
        if (session.getEventFactory() != null) {
            log.info("Clearing old event from game state '{}'", session.getGameState().getId());
            session.setEventFactory(null);
        }
        Event event = findByGameState(session.getGameState());
        EventFactory eventFactory = createEventFactory(session, event);
        session.setEventFactory(eventFactory);
    }

    public void update(GameSession session) {
        SessionEventUtil.update(session);
    }

    public void update(GameSession session, @NotNull Integer selectedOption) {
        SessionEventUtil.update(session, selectedOption);
    }

    private Event findByGameState(GameState gameState) {
        String locationId = gameState.getLocationId();
        CharacterProperties characterProperties = gameState.getCharacter().getProperties();
        List<Event> events = repository.findByLocationAndProperties(locationId, characterProperties);
        return events.isEmpty() ? null : events.get(0);
    }
}
