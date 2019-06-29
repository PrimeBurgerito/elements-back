package com.elements.gamesession.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.security.token-service")
public class TokenProperties {
    private String serverUri;
    private String clientId;
    private String clientSecret;
    private String clientIdSwagger;
    private String clientSecretSwagger;
    private String checkTokenEndpoint;
}
