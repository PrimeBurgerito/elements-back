package com.elements.elementsauth.config;

import com.elements.elementscommon.config.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    private static final String RESOURCE_ID = "resource_id";
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AuthProperties authProperties;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer serverSecurityConfigurer) {
        serverSecurityConfigurer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) {
        endpointsConfigurer
                .tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory();
        configureDefaultClient(clients);
        configureSwaggerClient(clients);
    }

    private void configureDefaultClient(ClientDetailsServiceConfigurer clients) {
        clients.and()
                .withClient(authProperties.getClientId())
                .secret(passwordEncoder.encode(authProperties.getClientSecret()))
                .accessTokenValiditySeconds(authProperties.getAccessTokenValiditySeconds())
                .refreshTokenValiditySeconds(authProperties.getRefreshTokenValiditySeconds())
                .scopes(authProperties.getScope())
                .resourceIds(RESOURCE_ID)
                .authorizedGrantTypes(authProperties.getGrantTypes());
    }

    private void configureSwaggerClient(ClientDetailsServiceConfigurer clients) {
        clients.and()
                .withClient(authProperties.getClientIdSwagger())
                .secret(passwordEncoder.encode(authProperties.getClientSecretSwagger()))
                .accessTokenValiditySeconds(authProperties.getAccessTokenValiditySeconds())
                .refreshTokenValiditySeconds(authProperties.getRefreshTokenValiditySeconds())
                .scopes(authProperties.getScope())
                .authorizedGrantTypes(authProperties.getGrantTypes())
                .resourceIds(RESOURCE_ID)
                .redirectUris("http://localhost:7777/webjars/springfox-swagger-ui/oauth2-redirect.html");
    }
}
