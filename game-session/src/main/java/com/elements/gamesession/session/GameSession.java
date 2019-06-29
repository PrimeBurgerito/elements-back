package com.elements.gamesession.session;

import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.location.Location;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Slf4j
@Component
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameSession {

    private GameState gameState;
    private Location location;

    @PostConstruct
    public void init() {
        if (gameState != null) {
            log.info("New websocket session created with gamestate: {}", gameState.getUserId());
        } else {
            log.info("New websocket session created without gamestate.");
        }
    }
}
