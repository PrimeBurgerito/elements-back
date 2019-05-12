package com.elements.gamesession.config.session;

import com.elements.elementscommon.domain.user.User;
import com.elements.gamesession.session.GameSession;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SessionEndedListener implements ApplicationListener<SessionDestroyedEvent> {

    private GameSession gameSession;

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        for (SecurityContext securityContext : event.getSecurityContexts()) {
            Authentication authentication = securityContext.getAuthentication();
            User user = (User) authentication.getPrincipal();
            // do something
        }
    }

}
