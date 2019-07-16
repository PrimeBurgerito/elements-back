package com.elements.gamesession.session;

import com.elements.gamesession.session.clientgamestate.domain.ClientGameState;
import com.elements.gamesession.session.event.service.SessionEventService;
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
    private final SessionEventService eventService;

    @MessageMapping(value = "/game-state")
    public ClientGameState getClientGameState() {
        return session.getClientGameState();
    }

    @MessageMapping(value = "/change-location")
    public ClientGameState changeLocation(@Payload String locationName) {
        locationService.update(locationName, session);
        eventService.update(session, null);
        return session.getClientGameState();
    }

    @MessageMapping(value = "/update-event")
    public ClientGameState updateEvent(@Payload String nextKey) {
        eventService.update(session, nextKey);
        return session.getClientGameState();
    }
}
