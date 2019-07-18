package com.elements.gamesession.session;

import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.event.scene.Scene;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.clientgamestate.domain.ClientGameState;
import com.elements.gamesession.session.event.domain.EventState;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static java.util.Objects.requireNonNull;

@Data
@Slf4j
@Component
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameSession {

    private GameState gameState;
    private EventState eventState;
    private ClientGameState clientGameState;

    @PostConstruct
    public void init() {
        log.info("Websocket session constructed [{}]", getClass());
    }

    @PreDestroy
    public void destroy() {
        log.info("Websocket session going to be destroyed [{}]", getClass());
    }

    public void setNewEvent(Event event) {
        eventState = new EventState(event);
        Scene scene = requireNonNull(event).getScenes().get(0);
        clientGameState.updateCurrentEvent(scene);
    }

    public void nextScene() {
        eventState.nextScene();
        changeScene();
    }

    public void chooseSceneOption(int option) {
        eventState.chooseOption(option);
        changeScene();
    }

    private void changeScene() {
        if (eventState.isScenePossible()) {
            clientGameState.updateCurrentEvent(eventState.getCurrentScene());
        } else {
            clearEvent();
        }
    }

    public void clearEvent() {
        clientGameState.setCurrentEvent(null);
        eventState = null;
    }
}
