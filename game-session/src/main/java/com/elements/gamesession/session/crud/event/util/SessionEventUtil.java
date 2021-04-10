package com.elements.gamesession.session.crud.event.util;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.scene.SceneBase;
import com.elements.elementsdomain.document.event.scene.reward.SceneReward;
import com.elements.elementsdomain.shared.character.Character;
import com.elements.elementsdomain.shared.reward.Reward;
import com.elements.gamesession.engine.reward.RewardEngine;
import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.crud.event.EventFactory;
import com.elements.gamesession.session.crud.event.domain.SceneStateOptionDTO;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.elements.elementsdomain.document.event.scene.SceneType.REWARD;
import static com.elements.gamesession.session.crud.event.util.SessionEventValidationUtil.validateEvent;
import static com.elements.gamesession.session.crud.event.util.SessionEventValidationUtil.validateOption;


@UtilityClass
public class SessionEventUtil {

    public static EventFactory createEventFactory(GameSession session, Event event) {
        SessionEventValidation validation = validateEvent(event);

        if (validation.isValid()) {
            Character character = session.getGameState().getCharacter();
            return new EventFactory(event, character.getProperties());
        }

        return null;
    }

    public static void update(GameSession session) {
        EventFactory eventFactory = session.getEventFactory();
        if (eventFactory == null) {
            throw new RuntimeException("No event started!");
        }
        eventFactory.nextScene();
        processCurrentScene(session);
    }

    public static void update(GameSession session, @NotNull Integer selectedOption) {
        EventFactory eventFactory = session.getEventFactory();
        if (eventFactory == null) {
            throw new RuntimeException("No event started!");
        }

        List<SceneStateOptionDTO> eventOptions = eventFactory.getCurrentSceneState().getOptions();
        SessionEventValidation validation = validateOption(eventOptions, selectedOption);

        if (validation.isValid()) {
            eventFactory.nextScene(selectedOption);
            processCurrentScene(session);
        } else {
            session.setEventFactory(null);
        }
    }

    private static void processCurrentScene(GameSession session) {
        SceneBase currentScene = session.getEventFactory().getCurrentScene();
        if (currentScene == null) {
            session.setEventFactory(null);
        } else {
            if (REWARD.equals(currentScene.getType())) {
                Reward reward = ((SceneReward) currentScene).getReward();
                RewardEngine.collectRewards(session, reward);
                update(session);
            }
        }
    }
}
