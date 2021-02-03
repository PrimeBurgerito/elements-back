package com.elements.gamesession.session.crud.event.service;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.scene.SceneBase;
import com.elements.elementsdomain.document.event.scene.reward.SceneReward;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.elementsdomain.shared.reward.Reward;
import com.elements.gamesession.engine.reward.RewardEngine;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.crud.event.domain.SceneStateOption;
import com.elements.gamesession.session.crud.event.domain.SessionEventUtil;
import com.elements.gamesession.session.crud.event.domain.SessionEventValidation;
import com.elements.gamesession.session.crud.event.repository.SessionEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.elements.elementsdomain.document.event.scene.SceneType.REWARD;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionEventService {

    private final SessionEventRepository repository;
    private final SessionEventValidationService validationService;

    public void setNewEvent(GameSession session) {
        if (session.getEventSession() != null) {
            log.info("Clearing old event from game state '{}'", session.getGameState().getId());
            SessionEventUtil.clearEvent(session);
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
        SessionEventUtil.nextScene(session);
        processRewardScene(session);
    }

    public void update(GameSession session, @NotNull Integer selectedOption) {
        if (session.getEventSession() == null) {
            throw new RuntimeException("No event started!");
        }
        List<SceneStateOption> eventOptions = session.getGameStateDTO().getCurrentScene().getOptions();
        SessionEventValidation validation = validationService.validate(eventOptions, selectedOption);
        if (validation.isCorrect()) {
            SessionEventUtil.chooseSceneOption(session, selectedOption);
            processRewardScene(session);
        } else {
            SessionEventUtil.clearEvent(session);
        }
    }

    private void processRewardScene(GameSession session) {
        SceneBase eventSession = session.getEventSession().getCurrentScene();
        if (REWARD.equals(eventSession.getType())) {
            Reward reward = ((SceneReward) eventSession).getReward();
            RewardEngine.collectRewards(session, reward);
            update(session);
        }
    }

    private Event findByGameState(GameState gameState) {
        //QEvent qEvent = new QEvent("event");
        String locationId = gameState.getLocationId();
        CharacterProperties characterProperties = gameState.getCharacter().getProperties();
        List<Event> events = repository.findByLocationAndProperties(locationId, characterProperties);
        return events.isEmpty() ? null : events.get(0);
    }
}
