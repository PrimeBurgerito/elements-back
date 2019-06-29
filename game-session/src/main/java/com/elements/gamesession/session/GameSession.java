package com.elements.gamesession.session;

import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.location.Location;
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
    private Location location;

    private ClientGameState clientGameState;

    @PostConstruct
    public void init() {
        log.info("Websocket session constructed [{}]", getClass());
    }

    @PreDestroy
    public void destroy() {
        log.info("Websocket session going to be destroyed [{}]", getClass());
    }
}
