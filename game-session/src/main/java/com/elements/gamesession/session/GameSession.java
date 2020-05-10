package com.elements.gamesession.session;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.crud.event.domain.EventSession;
import com.elements.gamesession.session.resource.gamestate.domain.GameStateResource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@Slf4j
@Component
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameSession {
    private GameState gameState;
    private EventSession eventSession;

    private GameStateResource gameStateResource;

    @PostConstruct
    public void init() {
        log.info("Websocket session constructed [{}]", getClass());
    }

    @PreDestroy
    public void destroy() {
        log.info("Websocket session going to be destroyed [{}]", getClass());
    }

    public void setNewEvent(Event event) {
        eventSession = new EventSession(event, gameState.getCharacter().getProperties());
        gameStateResource.setCurrentScene(eventSession.getCurrentSceneState());
    }

    public void updateGameStateResourceCharacterProperties() {
        gameStateResource.getCharacter().setProperties(gameState.getCharacter().getProperties());
    }
}
