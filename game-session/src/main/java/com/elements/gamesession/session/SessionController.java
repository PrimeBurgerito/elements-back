package com.elements.gamesession.session;

import com.elements.gamesession.session.clientgamestate.domain.ClientGameState;
import com.elements.gamesession.session.location.domain.SessionLocation;
import com.elements.gamesession.session.location.service.SessionLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@SendToUser(value = "/state/game")
public class SessionController {

    private final GameSession session;
    private final SessionLocationService locationService;

    @MessageMapping(value = "/game-state")
    public ClientGameState updateGameState() {
        return session.getClientGameState();
    }

    @MessageMapping(value = "/change-location")
    public ClientGameState changeLocation(@Payload String locationName) {
        SessionLocation sessionLocation = locationService.getChangedLocation(locationName, session.getGameState());
        session.getClientGameState().setLocation(sessionLocation);
        return session.getClientGameState();
    }
}
