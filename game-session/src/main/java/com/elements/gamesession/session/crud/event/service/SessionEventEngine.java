package com.elements.gamesession.session.crud.event.service;

import com.elements.elementsdomain.document.event.scene.SceneType;
import com.elements.gamesession.session.GameSession;
import lombok.experimental.UtilityClass;


@UtilityClass
class SessionEventEngine {

    SceneType nextScene(GameSession session) {
        session.getEventSession().nextScene();
        return changeScene(session);
    }

    SceneType chooseSceneOption(GameSession session, int option) {
        session.getEventSession().chooseOption(option);
        return changeScene(session);
    }

    private SceneType changeScene(GameSession session) {
        if (session.getEventSession().getCurrentSceneState() != null) {
            session.getGameStateResource().setCurrentScene(session.getEventSession().getCurrentSceneState());
            return session.getGameStateResource().getCurrentScene().getType();
        } else {
            clearEvent(session);
            return null;
        }
    }

    void clearEvent(GameSession session) {
        session.getGameStateResource().setCurrentScene(null);
        session.setEventSession(null);
    }
}
