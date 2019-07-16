package com.elements.gamesession.session.event.service;

import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.event.scene.Scene;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.event.domain.EventState;
import com.elements.gamesession.session.event.domain.SessionEvent;
import com.elements.gamesession.session.event.domain.SessionEventValidation;
import com.elements.gamesession.session.event.repository.SessionEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.elements.gamesession.session.event.domain.SessionEventMapper.map;
import static java.util.Objects.requireNonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionEventService {

    private final SessionEventRepository repository;
    private final SessionEventValidationService validationService;

    public void setNewEvent(GameSession session) {
        GameState gameState = session.getGameState();
        Event event = findByGameState(gameState);
        SessionEventValidation validation = validationService.validate(event);
        if (validation.isCorrect()) {
            session.setEventState(new EventState(event));
            Scene scene = requireNonNull(event).getScenes().get(0);
            SessionEvent sessionEvent = map(scene, gameState.getCharacter().getStatistics());
            session.getClientGameState().setCurrentEvent(sessionEvent);
        }
    }

    public void update(GameSession session, Integer option) {
        if (session.getEventState() == null) {
            throw new RuntimeException("Event state can't be null with option!");
        } else if (option == null) {
            setNextScene(session);
        } else {
            setNextScene(session, option);
        }
    }

    private void setNextScene(GameSession session) {
        GameState gameState = session.getGameState();
        Event event = session.getEventState().getEvent();
        int nextScene = session.getEventState().getCurrentScene() + 1;
        if (nextScene < event.getScenes().size()) {
            session.getEventState().setCurrentScene(nextScene);
            SessionEvent sessionEvent = map(event.getScenes().get(nextScene), gameState.getCharacter().getStatistics());
            session.getClientGameState().setCurrentEvent(sessionEvent);
        } else {
            removeEvent(session);
        }

    }

    private void setNextScene(GameSession session, Integer option) {
        GameState gameState = session.getGameState();
        Event event = session.getEventState().getEvent();
        if (option != null && option < event.getScenes().size()) {
            session.getEventState().setCurrentScene(option);
            SessionEvent sessionEvent = map(event.getScenes().get(option), gameState.getCharacter().getStatistics());
            session.getClientGameState().setCurrentEvent(sessionEvent);
        } else {
            log.error("Option can't be null or index out of bounds");
            removeEvent(session);
        }
    }

    private void removeEvent(GameSession session) {
        session.getClientGameState().setCurrentEvent(null);
        session.setEventState(null);
    }

    private Event findByGameState(GameState gameState) {
        List<Event> events = repository.findByGameState(gameState);
        return events.isEmpty() ? null : events.get(0);
    }
}
