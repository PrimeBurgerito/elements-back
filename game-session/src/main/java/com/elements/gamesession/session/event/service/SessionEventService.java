package com.elements.gamesession.session.event.service;

import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.event.scene.SceneType;
import com.elements.elementsdomain.event.scene.reward.SceneReward;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.reward.Reward;
import com.elements.gamesession.engine.reward.RewardEngine;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.event.domain.SessionEventValidation;
import com.elements.gamesession.session.event.domain.SessionOption;
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
            SessionEventEngine.clearEvent(session);
        }
        Event event = findByGameState(session.getGameState());
        SessionEventValidation validation = validationService.validate(event);
        if (validation.isCorrect()) {
            session.setNewEvent(event);
        }
    }

    public void update(GameSession session) {
        if (session.getEventState() == null) {
            throw new RuntimeException("No event started!");
        }
        SceneType newSceneType = SessionEventEngine.nextScene(session);
        processRewardScene(session, newSceneType);
    }

    public void update(GameSession session, Integer selectedOption) {
        if (session.getEventState() == null) {
            throw new RuntimeException("No event started!");
        }
        List<SessionOption> eventOptions = session.getClientGameState().getCurrentEvent().getOptions();
        SessionEventValidation validation = validationService.validate(eventOptions, selectedOption);
        if (validation.isCorrect()) {
            SceneType newSceneType = SessionEventEngine.chooseSceneOption(session, selectedOption);
            processRewardScene(session, newSceneType);
        } else {
            SessionEventEngine.clearEvent(session);
        }
    }

    private void processRewardScene(GameSession session, SceneType sceneType) {
        if (sceneType != null && sceneType.equals(SceneType.REWARD)) {
            Reward reward = ((SceneReward) session.getEventState().getCurrentScene()).getReward();
            RewardEngine.collectRewards(session, reward);
            update(session);
        }
    }

    private Event findByGameState(GameState gameState) {
        List<Event> events = repository.findByGameState(gameState);
        return events.isEmpty() ? null : events.get(0);
    }
}
