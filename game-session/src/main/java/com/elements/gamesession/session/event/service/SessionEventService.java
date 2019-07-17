package com.elements.gamesession.session.event.service;

import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.event.domain.SessionEventValidation;
import com.elements.gamesession.session.event.repository.SessionEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionEventService {

    private final SessionEventRepository repository;
    private final SessionEventValidationService validationService;

    public void setNewEvent(GameSession session) {
        if (session.getEventState() != null) {
            log.info("Clearing old event - Id: {}", session.getEventState().getEvent().getId());
            session.clearEvent();
        }
        Event event = findByGameState(session.getGameState());
        SessionEventValidation validation = validationService.validate(event);
        if (validation.isCorrect()) {
            session.setNewEvent(event);
        }
    }

    public void update(GameSession session, Integer option) {
        if (session.getEventState() == null) {
            throw new RuntimeException("Event state can't be null with option!");
        } else if (option == null) {
            session.nextScene();
        } else {
            setNextScene(session, option);
        }
    }

    private void setNextScene(GameSession session, Integer selectedOption) {
        SessionEventValidation validation = validationService
                .validate(session.getClientGameState().getCurrentEvent().getOptions(), selectedOption);
        if (validation.isCorrect()) {
            session.nextScene(selectedOption);
        } else {
            session.clearEvent();
        }
    }

    private Event findByGameState(GameState gameState) {
        List<Event> events = repository.findByGameState(gameState);
        return events.isEmpty() ? null : events.get(0);
    }
}
