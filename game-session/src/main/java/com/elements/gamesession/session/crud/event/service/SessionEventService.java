package com.elements.gamesession.session.crud.event.service;

import com.elements.elementsdomain.shared.reward.Reward;
import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.scene.SceneType;
import com.elements.elementsdomain.document.event.scene.reward.SceneReward;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.engine.reward.RewardEngine;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.crud.event.domain.SceneStateOption;
import com.elements.gamesession.session.crud.event.domain.SessionEventValidation;
import com.elements.gamesession.session.crud.event.repository.SessionEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionEventService {

    private final SessionEventRepository repository;
    private final SessionEventValidationService validationService;

    public void setNewEvent(GameSession session) {
        if (session.getEventSession() != null) {
            log.info("Clearing old event - Id: {}", session.getEventSession().getEvent().getId());
            SessionEventEngine.clearEvent(session);
        }
        Event event = findByGameState(session.getGameState());
        SessionEventValidation validation = validationService.validate(event);
        if (validation.isCorrect()) {
            session.setNewEvent(event);
        }
    }

    public void update(GameSession session) {
        if (session.getEventSession() == null) {
            throw new RuntimeException("No event started!");
        }
        SceneType newSceneType = SessionEventEngine.nextScene(session);
        processRewardScene(session, newSceneType);
    }

    public void update(GameSession session, @NotNull Integer selectedOption) {
        if (session.getEventSession() == null) {
            throw new RuntimeException("No event started!");
        }
        List<SceneStateOption> eventOptions = session.getGameStateResource().getCurrentScene().getOptions();
        SessionEventValidation validation = validationService.validate(eventOptions, selectedOption);
        if (validation.isCorrect()) {
            SceneType newSceneType = SessionEventEngine.chooseSceneOption(session, selectedOption);
            processRewardScene(session, newSceneType);
        } else {
            SessionEventEngine.clearEvent(session);
        }
    }

    private void processRewardScene(GameSession session, SceneType sceneType) {
        if (SceneType.REWARD.equals(sceneType)) {
            Reward reward = ((SceneReward) session.getEventSession().getCurrentScene()).getReward();
            RewardEngine.collectRewards(session, reward);
            update(session);
        }
    }

    private Event findByGameState(GameState gameState) {
        //QEvent qEvent = new QEvent("event");
        List<Event> events = repository
                .findByLocationAndProperties(gameState.getLocationId(), gameState.getCharacter().getProperties());
        return events.isEmpty() ? null : events.get(0);
    }
}
