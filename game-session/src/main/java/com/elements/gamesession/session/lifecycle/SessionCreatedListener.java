package com.elements.gamesession.session.lifecycle;

import com.elements.gamesession.session.GameSession;
import com.elements.gamesession.session.GameSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class SessionCreatedListener implements ApplicationListener<SessionConnectedEvent> {

    private final GameSession gameSession;
    private final GameSessionService gameSessionService;

    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        log.info("WebSocket Session Connected: {}", event.getMessage());
        log.info("Connect event [sessionId: {} ]", sha.getSessionId());
        if (event.getUser() != null) {
            String username = event.getUser().getName();
            gameSessionService.updateForUser(gameSession, username);
        } else {
            log.warn("User not found from session event!");
        }
    }
}
