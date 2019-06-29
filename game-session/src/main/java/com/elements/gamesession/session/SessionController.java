package com.elements.gamesession.session;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SessionController {

    private final GameSession session;

    @MessageMapping(value = "/test")
    @SendToUser(value = "/state/game")
    public String test(@Payload String input) {
        if (session.getGameState() != null) {
            return input + "works with" + session.getGameState().getUserId();
        }
        return input + "works without gamestate";
    }
}
