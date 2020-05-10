package com.elements.gamesession.session;

import com.elements.gamesession.session.resource.gamestate.domain.GameStateResource;
import com.elements.gamesession.session.crud.event.service.SessionEventService;
import com.elements.gamesession.session.crud.location.service.SessionLocationService;
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
    private final SessionLocationService sessionLocationService;
    private final SessionEventService sessionEventService;

    @MessageMapping(value = "/game-state")
    public GameStateResource getClientGameState() {
        return session.getGameStateResource();
    }

    @MessageMapping(value = "/change-location")
    public GameStateResource changeLocation(@Payload String locationName) {
        sessionLocationService.setNewLocation(locationName, session);
        sessionEventService.setNewEvent(session);
        return session.getGameStateResource();
    }

    @MessageMapping(value = "/update-event")
    public GameStateResource updateEvent(@Payload(required = false) Integer selectedOption) {
        if (selectedOption == null) {
            sessionEventService.update(session);
        } else {
            sessionEventService.update(session, selectedOption);
        }
        return session.getGameStateResource();
    }
}
