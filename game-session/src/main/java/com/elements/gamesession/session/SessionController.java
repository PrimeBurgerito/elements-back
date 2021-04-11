package com.elements.gamesession.session;

import com.elements.elementscommon.domain.user.User;
import com.elements.gamesession.session.resource.GameStateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import static java.text.MessageFormat.format;

@RestController
@RequiredArgsConstructor
@SendToUser(value = "/state/game")
public class SessionController {

    private final GameSession session;
    private final GameSessionService sessionService;

    @MessageMapping(value = "/test")
    public String test(@Payload String callBack) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return format("Hello {0} [user: {1}]", callBack, user.getUsername());
    }

    @MessageMapping(value = "/game-state")
    public GameStateDTO getClientGameState() {
        return session.getGameStateDTO();
    }

    @MessageMapping(value = "/change-location")
    public GameStateDTO changeLocation(@Payload String locationName) {
        sessionService.setNewLocation(session, locationName);
        return session.getGameStateDTO();
    }

    @MessageMapping(value = "/update-event")
    public GameStateDTO updateEvent(@Payload(required = false) Integer selectedOption) {
        sessionService.updateEvent(session, selectedOption);
        return session.getGameStateDTO();
    }
}
