package com.elements.gamesession.session.lifecycle;

import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.crud.gamestate.service.GameStateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class SessionEndedListener implements ApplicationListener<SessionDisconnectEvent> {

    private final GameSession gameSession;
    private final GameStateService gameStateService;

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        log.info("WebSocket Session Disconnected: {}", event.getMessage());
        log.info("Disconnect event [sessionId: {}]", sha.getSessionId());
        gameStateService.save(gameSession.getGameState());
    }
}
