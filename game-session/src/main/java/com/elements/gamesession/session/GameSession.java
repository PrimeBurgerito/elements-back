package com.elements.gamesession.session;

import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.location.Location;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameSession {
    private GameState gameState;
    private Location location;
}
