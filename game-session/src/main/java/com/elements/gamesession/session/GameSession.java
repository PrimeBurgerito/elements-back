package com.elements.gamesession.session;

import com.elements.elementsdomain.document.location.Location;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.crud.event.EventFactory;
import com.elements.gamesession.session.crud.event.domain.SceneStateDTO;
import com.elements.gamesession.session.crud.location.domain.LocationStateDTO;
import com.elements.gamesession.session.crud.location.domain.SessionLocationMapper;
import com.elements.gamesession.session.resource.GameStateDTO;
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
    private Location currentLocation;
    private EventFactory eventFactory;

    @PostConstruct
    public void init() {
        String state = gameState == null ? "NOT_CREATED" : gameState.getId();
        log.info("Websocket session constructed for game state '{}' [{}]", state, getClass());
    }

    @PreDestroy
    public void destroy() {
        log.info("Websocket session going to be destroyed for game state '{}' [{}]", gameState.getId(), getClass());
    }

    public GameStateDTO getGameStateDTO() {
        LocationStateDTO location = SessionLocationMapper.map(currentLocation, gameState.getCharacter().getProperties());
        SceneStateDTO currentScene = eventFactory == null ? null : eventFactory.getCurrentSceneState();
        return new GameStateDTO(gameState.getCharacter(), location, currentScene);
    }
}
