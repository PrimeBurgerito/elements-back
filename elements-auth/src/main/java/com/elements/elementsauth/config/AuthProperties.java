package com.elements.elementsauth.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "spring.security.oauth2")
public class AuthProperties {
    private String clientId;
    private String clientSecret;
    private String clientIdSwagger;
    private String clientSecretSwagger;
    private String refreshToken;
    private String[] grantTypes;
    private String[] scope;
    private int accessTokenValiditySeconds;
    private int refreshTokenValiditySeconds;
}
