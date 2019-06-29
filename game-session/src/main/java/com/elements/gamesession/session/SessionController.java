package com.elements.gamesession.session;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SessionController {

    private final GameSession session;

    @MessageMapping(value = "/game-state")
    @SendToUser(value = "/state/game")
    public ClientGameState updateGameState() {
        return session.getClientGameState();
    }
}
