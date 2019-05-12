package com.elements.gamesession.config;

import com.elements.elementscommon.config.SecurityConfiguration;
import com.elements.gamesession.config.session.SessionConfiguration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityInitializer() {
        super(SecurityConfiguration.class, SessionConfiguration.class);
    }
}
