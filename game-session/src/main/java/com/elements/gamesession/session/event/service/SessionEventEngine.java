package com.elements.gamesession.session.event.service;

import com.elements.elementsdomain.aggregate.event.scene.SceneType;
import com.elements.gamesession.session.GameSession;

class SessionEventEngine {

    private SessionEventEngine() {
    }

    static SceneType nextScene(GameSession session) {
        session.getEventState().nextScene();
        return changeScene(session);
    }

    static SceneType chooseSceneOption(GameSession session, int option) {
        session.getEventState().chooseOption(option);
        return changeScene(session);
    }

    private static SceneType changeScene(GameSession session) {
        if (session.getEventState().getCurrentSessionEvent() != null) {
            session.getClientGameState().setCurrentEvent(session.getEventState().getCurrentSessionEvent());
            return session.getClientGameState().getCurrentEvent().getType();
        } else {
            clearEvent(session);
            return null;
        }
    }

    static void clearEvent(GameSession session) {
        session.getClientGameState().setCurrentEvent(null);
        session.setEventState(null);
    }
}
