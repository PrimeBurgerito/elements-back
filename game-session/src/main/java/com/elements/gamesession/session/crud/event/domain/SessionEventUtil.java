package com.elements.gamesession.session.crud.event.domain;

import com.elements.gamesession.session.GameSession;
import lombok.experimental.UtilityClass;


@UtilityClass
public class SessionEventUtil {

    public void nextScene(GameSession session) {
        session.getEventSession().nextScene();
        replaceSceneOnResource(session);
    }

    public void chooseSceneOption(GameSession session, int option) {
        session.getEventSession().nextScene(option);
        replaceSceneOnResource(session);
    }

    private void replaceSceneOnResource(GameSession session) {
        SceneState currentSceneState = session.getEventSession().getCurrentSceneState();
        if (currentSceneState != null) {
            session.getGameStateDTO().setCurrentScene(currentSceneState);
        } else {
            clearEvent(session);
        }
    }

    public void clearEvent(GameSession session) {
        session.getGameStateDTO().setCurrentScene(null);
        session.setEventSession(null);
    }
}
